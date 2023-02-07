package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.IMasterItemClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IMasterItemClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:15
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IMasterItemClientFeign extends IMasterItemClient {
}
