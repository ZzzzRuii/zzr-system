package com.zzr.apollo.feign;

import com.zzr.apollo.feign.master.ICancelRuleClient;
import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingCancelRuleVO;
import com.zzr.apollo.service.IBookingCancelRuleService;
import com.zzr.apollo.wrapper.BookingCancelRuleWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * ICancelRuleClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 14:57
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CancelRuleClient implements ICancelRuleClient {

    private final IBookingCancelRuleService service;


    /**
     * 查询取消规则 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingCancelRuleVO>> selectPage(Query query, QueryBookingCancelRuleDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建对象BookingCancelRule
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateBookingCancelRuleDTO dto) {
        return R.data(service.create(dto).getId());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingCancelRuleVO> detail(Long id) {
        return R.data(BookingCancelRuleWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 根据Id 更新 BookingCancelRule对象
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingCancelRuleDTO dto) {
        return R.data(service.update(dto, id));
    }

    /**
     * 根据id删除BookingCancelRule
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return R.data(service.deleteById(id));
    }

    /**
     * 根据id激活取消规则
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return R.data(service.activate(id));
    }

    /**
     * 根据id停用取消规则
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> inactivate(Long id) {
        return R.data(service.inactivate(id));
    }
}
