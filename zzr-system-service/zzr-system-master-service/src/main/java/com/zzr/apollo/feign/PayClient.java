package com.zzr.apollo.feign;

import cn.hutool.core.util.ObjectUtil;
import com.zzr.apollo.feign.master.IPayClient;
import com.zzr.apollo.master.dto.CreateBookingMasterPayDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterPayDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterPayDTO;
import com.zzr.apollo.master.vo.BookingMasterPayVO;
import com.zzr.apollo.model.BookingMasterPayDO;
import com.zzr.apollo.service.IBookingMasterPayService;
import com.zzr.apollo.wrapper.BookingMasterPayWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * PayClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 15:01
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PayClient implements IPayClient {

    private final IBookingMasterPayService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingMasterPayVO>> selectPage(Query query, QueryBookingMasterPayDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateBookingMasterPayDTO dto) {
        BookingMasterPayDO entity = service.create(dto);
        return R.data(ObjectUtil.isNotNull(entity) ? entity.getId() : null);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingMasterPayVO> detail(Long id) {
        return R.data(BookingMasterPayWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingMasterPayDTO dto) {
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
     * 激活
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return R.data(service.activate(id));
    }

    /**
     * 停用
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> inactivate(Long id) {
        return R.data(service.inactivate(id));
    }
}
