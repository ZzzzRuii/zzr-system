package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.IRefundClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IRefundClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:16
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IRefundClientFeign extends IRefundClient {
}
