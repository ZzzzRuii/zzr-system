package com.zzr.apollo.feign;

import com.zzr.apollo.feign.master.IMasterClient;
import com.zzr.apollo.master.dto.CreateBookingMasterDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterDTO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.wrapper.BookingMasterWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * MasterClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 14:59
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MasterClient implements IMasterClient {

    private final IBookingMasterService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingMasterVO>> selectPage(Query query, QueryBookingMasterDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return 主订单id
     */
    @Override
    public R<Long> create(CreateBookingMasterDTO dto) {
        return R.data(service.create(dto).getId());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingMasterVO> detail(Long id) {
        return R.data(BookingMasterWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingMasterDTO dto) {
        return R.data(service.update(dto, id));
    }

    /**
     * 根据id删除BookingMaster
     *
     * @param id 主键
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
