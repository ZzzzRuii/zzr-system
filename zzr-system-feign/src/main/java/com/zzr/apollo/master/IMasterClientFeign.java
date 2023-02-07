package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.IMasterClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IMasterClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:14
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IMasterClientFeign extends IMasterClient {
}
