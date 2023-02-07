package com.zzr.apollo.unit;

import com.zzr.apollo.feign.unit.ISystemUnitChainInfoClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ISystemUnitChainInfoClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:58
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface ISystemUnitChainInfoClientFeign extends ISystemUnitChainInfoClient {
}
