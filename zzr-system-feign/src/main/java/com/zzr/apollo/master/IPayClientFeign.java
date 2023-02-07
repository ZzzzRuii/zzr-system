package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.IPayClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IPayClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:15
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IPayClientFeign extends IPayClient {
}
