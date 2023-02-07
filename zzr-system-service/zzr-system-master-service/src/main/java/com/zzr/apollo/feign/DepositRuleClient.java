package com.zzr.apollo.feign;

import com.zzr.apollo.feign.master.IDepositRuleClient;
import com.zzr.apollo.master.dto.CreateBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingDepositRuleDTO;
import com.zzr.apollo.master.vo.BookingDepositRuleVO;
import com.zzr.apollo.service.IBookingDepositRuleService;
import com.zzr.apollo.wrapper.BookingDepositRuleWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * DepositRuleClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 14:58
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class DepositRuleClient implements IDepositRuleClient {

    private final IBookingDepositRuleService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingDepositRuleVO>> selectPage(Query query, QueryBookingDepositRuleDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateBookingDepositRuleDTO dto) {
        return R.data(service.create(dto).getId());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingDepositRuleVO> detail(Long id) {
        return R.data(BookingDepositRuleWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingDepositRuleDTO dto) {
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
