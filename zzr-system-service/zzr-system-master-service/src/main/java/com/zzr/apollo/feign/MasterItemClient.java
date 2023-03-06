package com.zzr.apollo.feign;

import cn.hutool.core.util.ObjectUtil;
import com.zzr.apollo.feign.master.IMasterItemClient;
import com.zzr.apollo.master.dto.CreateBookingMasterItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.apollo.service.IBookingMasterItemService;
import com.zzr.apollo.wrapper.BookingMasterItemWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * MasterItemClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 14:59
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MasterItemClient implements IMasterItemClient {

    private final IBookingMasterItemService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingMasterItemVO>> selectPage(Query query, QueryBookingMasterItemDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return 子订单id
     */
    @Override
    public R<Long> create(CreateBookingMasterItemDTO dto) {
        BookingMasterItemDO entity = service.create(dto);
        return R.data(ObjectUtil.isNotNull(entity) ? entity.getId() : null);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingMasterItemVO> detail(Long id) {
        return R.data(BookingMasterItemWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingMasterItemDTO dto) {
        return R.data(service.update(dto, id));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return R.data(service.deleteById(id));
    }

    /**
     * 根据主键 预付款
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> reserve(Long id) {
        return R.data(service.reserve(id));
    }

    /**
     * 根据主键 已付款
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> rePay(Long id) {
        return R.data(service.rePay(id));
    }

    /**
     * 根据主键 已取消
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> canceled(Long id) {
        return R.data(service.canceled(id));
    }

    /**
     * 根据主键 确认中
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> confirming(Long id) {
        return R.data(service.confirming(id));
    }

    /**
     * 根据主键 已确认
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> confirmed(Long id) {
        return R.data(service.confirmed(id));
    }

    /**
     * 根据主键 执行中
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> doing(Long id) {
        return R.data(service.doing(id));
    }

    /**
     * 根据主键 完成
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> complete(Long id) {
        return R.data(service.complete(id));
    }
}
