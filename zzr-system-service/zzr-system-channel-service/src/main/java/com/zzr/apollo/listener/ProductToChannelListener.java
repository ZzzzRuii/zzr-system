package com.zzr.apollo.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.alibaba.nacos.shaded.com.google.gson.reflect.TypeToken;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.event.ProductCreateEvent;
import com.zzr.apollo.event.ProductDeleteEvent;
import com.zzr.apollo.event.ProductUpdateEvent;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.apollo.model.CmmProductDailyChannelRateDO;
import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.service.ICmmProductDailyAmountService;
import com.zzr.apollo.service.ICmmProductDailyChannelRateService;
import com.zzr.apollo.tool.constants.AmountModelCode;
import com.zzr.apollo.tool.constants.RateSrcCode;
import org.springframework.beans.BeanUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 产品消息监听类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/10 13:09
 */
@Component
public class ProductToChannelListener {

    @Resource
    private ICmmProductDailyAmountService amountService;
    @Resource
    private ICmmProductDailyChannelRateService rateService;

    @EventListener
    public void onEvent(ProductCreateEvent event) {
        HashMap<String, String> productMap = event.getProductDO();
        Gson gson = new Gson();
        ProductTicketDO productDO = gson.fromJson(gson.toJson(productMap), new TypeToken<ProductTicketDO>() {
        }.getType());
        // 库存更新
        CreateCmmProductDailyAmountDTO dto = new CreateCmmProductDailyAmountDTO();
        BeanUtils.copyProperties(productDO, dto);
        dto.setModel(productDO.getStockMode());
        dto.setProductId(productDO.getId());
        dto.setProductCode(productDO.getCode());
        dto.setProductName(productDO.getName());
        dto.setProductType(productDO.getCatalog());
        amountService.create(dto);
        // 价格创建
        CreateCmmProductDailyChannelRateDTO rateDTO = new CreateCmmProductDailyChannelRateDTO();
        BeanUtils.copyProperties(productDO, rateDTO);
        rateDTO.setProductId(productDO.getId());
        rateDTO.setProductCode(productDO.getCode());
        rateDTO.setProductName(productDO.getName());
        rateDTO.setProductType(productDO.getCatalog());
        rateDTO.setSrc(RateSrcCode.INTERFACE);
        rateService.create(rateDTO);
    }

    @EventListener
    public void onEvent(ProductUpdateEvent event) {
        HashMap<String, String> productMap = event.getProductDO();
        List<Long> ids = CollUtil.newArrayList();
        // 库存更新
        List<CmmProductDailyAmountDO> amountList = amountService.selectByProductId(Long.parseLong(productMap.get("id")));
        amountList.forEach(item -> {
            item.setModel(productMap.get("stockMode"));
            switch (item.getModel()) {
                case AmountModelCode.UNLIMITED:
                    item.setNum(Integer.MAX_VALUE);
                    break;
                case AmountModelCode.TOTAL:
                    item.setNum(Integer.parseInt(productMap.get("num")) / AmountModelCode.DEFAULT_DATE);
                    break;
                default:
                    item.setNum(Integer.parseInt(productMap.get("num")));
                    break;
            }
            ids.add(item.getId());
        });
        amountService.changeStatus(ids, productMap.get("status"));
        amountService.updateBatchById(amountList);
        // 价格更新
        List<CmmProductDailyChannelRateDO> rateList = rateService.selectByProductId(Long.parseLong(productMap.get("id")));
        List<Long> idList = CollUtil.newArrayList();
        rateList.forEach(item -> {
            item.setStandardPrice(NumberUtil.toBigDecimal(productMap.get("standardPrice")));
            item.setRealPrice(NumberUtil.toBigDecimal(productMap.get("realPrice")));
            idList.add((item.getId()));
        });
        rateService.changeStatus(idList, productMap.get("status"));
        rateService.updateBatchById(rateList);
    }

    @EventListener
    public void onEvent(ProductDeleteEvent event) {
        HashMap<String, String> productMap = event.getProductDO();
        // 库存删除
        List<CmmProductDailyAmountDO> amountList = amountService.selectByProductId(Long.parseLong(productMap.get("id")));
        amountList.forEach(item -> {
            amountService.deleteById(item.getId());
        });
        // 价格删除
        List<CmmProductDailyChannelRateDO> rateList = rateService.selectByProductId(Long.parseLong(productMap.get("id")));
        rateList.forEach(item -> {
            rateService.deleteById(item.getId());
        });
    }
}
