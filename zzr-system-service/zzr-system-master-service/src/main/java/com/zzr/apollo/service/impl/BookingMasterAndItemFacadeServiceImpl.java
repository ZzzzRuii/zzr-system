package com.zzr.apollo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.zzr.apollo.mapper.BookingMasterAndItemFacadeMapper;
import com.zzr.apollo.master.dto.*;
import com.zzr.apollo.master.vo.BookingMasterAndItemFacadeVO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.apollo.model.BookingMasterAndItemFacadeDO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.apollo.service.IBookingMasterAndItemFacadeService;
import com.zzr.apollo.service.IBookingMasterItemService;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.wrapper.BookingMasterWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单合并服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:40
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterAndItemFacadeServiceImpl extends ZzrServiceImpl<BookingMasterAndItemFacadeMapper, BookingMasterAndItemFacadeDO> implements IBookingMasterAndItemFacadeService {

    private final IBookingMasterService masterService;

    private final IBookingMasterItemService itemService;

    /**
     * 根据参数 查询数据
     * 树形
     *
     * @param facadeDTO
     * @return
     */
    @Override
    public List<BookingMasterAndItemFacadeVO> selectTree(QueryBookingMasterAndItemFacadeDTO facadeDTO) {

        // 获取订单数据，并组装
        List<BookingMasterDO> masterList = masterService.list();
        List<BookingMasterVO> voList = CollUtil.newArrayList();
        masterList.forEach(item -> voList.add(BookingMasterWrapper.build().entityVO(item)));

        List<BookingMasterAndItemFacadeVO> facadeList = CollUtil.newArrayList();

        for (BookingMasterVO masterItem : voList) {
            BookingMasterAndItemFacadeVO facadeVO = new BookingMasterAndItemFacadeVO();
            List<BookingMasterItemVO> itemList = itemService.selectByOrderId(masterItem.getId());
            BeanUtils.copyProperties(masterItem, facadeVO);
            facadeVO.setItem(itemList);
            facadeList.add(facadeVO);
        }

        return facadeList;
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param facadeDTO
     * @return
     */
    @Override
    public BookingMasterAndItemFacadeVO create(CreateBookingMasterAndItemFacadeDTO facadeDTO) {
        // 订单创建，订单退款创建
        CreateBookingMasterDTO masterDTO = new CreateBookingMasterDTO();
        BeanUtils.copyProperties(facadeDTO, masterDTO);
        if (ObjectUtil.isNull(masterDTO.getDiscountFee())) {
            masterDTO.setDiscountFee(NumberUtil.toBigDecimal(0));
        }
        BookingMasterDO masterDO = masterService.create(masterDTO);

        List<BookingMasterItemVO> itemList = facadeDTO.getItem();
        BigDecimal finalFee = NumberUtil.toBigDecimal(0);
        BigDecimal num = NumberUtil.toBigDecimal(0);
        for (BookingMasterItemVO item : itemList) {
            CreateBookingMasterItemDTO itemDTO = new CreateBookingMasterItemDTO();
            BeanUtil.copyProperties(item, itemDTO);
            BeanUtil.copyProperties(masterDO, itemDTO);

            itemDTO.setConfirmNo(RandomUtil.randomNumbers(10));
            itemDTO.setConfirmTime(LocalDateTime.now());
            itemDTO.setOrderId(masterDO.getId());
            // 计算游玩时间
            itemDTO.setArr(masterDO.getTravelDate());
            itemDTO.setDep(masterDO.getTravelDate().plusDays(1L));

            // 创建子订单
            BookingMasterItemDO itemDO = itemService.create(itemDTO);
            BeanUtil.copyProperties(itemDO, item);
            // 计算存入主订单的总金额
            finalFee = finalFee.add(item.getFinalFee());
            num = num.add(itemDO.getNum());
        }

        if (ObjectUtil.isNull(masterDO.getDiscountFee())) {
            masterDO.setDiscountFee(NumberUtil.toBigDecimal(0));
        }
        // 主订单更新
        masterDO.setTotalFee(finalFee);
        masterDO.setQuantity(NumberUtil.parseInt(StrUtil.toString(num)));
        if (ObjectUtil.equals(masterDO.getTotalFee(), 0)) {
            masterDO.setFinalFee(masterDO.getTotalFee());
        } else {
            masterDO.setFinalFee(masterDO.getTotalFee().subtract(masterDO.getDiscountFee()));
        }

        UpdateBookingMasterDTO dto = new UpdateBookingMasterDTO();
        dto.setTotalFee(masterDO.getTotalFee());
        dto.setQuantity(masterDO.getQuantity());
        dto.setFinalFee(masterDO.getFinalFee());
        masterService.update(dto, masterDO.getId());

        // 订单组装成VO返回
        BookingMasterAndItemFacadeVO facadeVO = new BookingMasterAndItemFacadeVO();
        BeanUtils.copyProperties(masterDO, facadeVO);
        facadeVO.setItem(itemList);

        return facadeVO;
    }

}