package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.IRefundItemClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IRefundItemClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:17
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IRefundItemClientFeign extends IRefundItemClient {
}
