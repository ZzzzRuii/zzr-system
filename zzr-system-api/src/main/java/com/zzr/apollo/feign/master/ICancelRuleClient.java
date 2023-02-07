package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingCancelRuleVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * ICancelRuleClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 12:59
 */
public interface ICancelRuleClient {
    /**
     * 查询取消规则 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_CANCEL_RULE)
    R<Page<BookingCancelRuleVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingCancelRuleDTO dto);

    /**
     * 创建对象BookingCancelRule
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_CANCEL_RULE)
    R<Long> create(@RequestBody CreateBookingCancelRuleDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_CANCEL_RULE + "/{id}")
    R<BookingCancelRuleVO> detail(@PathVariable("id") Long id);

    /**
     * 根据Id 更新 BookingCancelRule对象
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_CANCEL_RULE + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingCancelRuleDTO dto);

    /**
     * 根据id删除BookingCancelRule
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_CANCEL_RULE + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据id激活取消规则
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.MASTER_CANCEL_RULE + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 根据id停用取消规则
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.MASTER_CANCEL_RULE + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);
}
