package com.zzr.apollo.master;

import com.zzr.apollo.feign.master.ICancelRuleClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ICancelRuleClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:13
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface ICancelRuleClientFeign extends ICancelRuleClient {
}
