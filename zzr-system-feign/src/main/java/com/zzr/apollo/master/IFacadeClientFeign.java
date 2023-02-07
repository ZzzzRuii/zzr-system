package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.IFacadeClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IFacadeClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:14
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IFacadeClientFeign extends IFacadeClient {
}
