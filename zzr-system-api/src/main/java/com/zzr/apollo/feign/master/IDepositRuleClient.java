package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingDepositRuleDTO;
import com.zzr.apollo.master.vo.BookingDepositRuleVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * DepositRuleClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:00
 */
public interface IDepositRuleClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_DEPOSIT_RULE)
    R<Page<BookingDepositRuleVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingDepositRuleDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_DEPOSIT_RULE)
    R<Long> create(@RequestBody CreateBookingDepositRuleDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_DEPOSIT_RULE + "/{id}")
    R<BookingDepositRuleVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_DEPOSIT_RULE + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingDepositRuleDTO dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_DEPOSIT_RULE + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 激活
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_DEPOSIT_RULE + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 停用
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_DEPOSIT_RULE + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);
}
