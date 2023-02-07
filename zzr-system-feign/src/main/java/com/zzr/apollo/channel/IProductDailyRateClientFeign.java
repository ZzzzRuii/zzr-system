package com.zzr.apollo.channel;

import com.zzr.apollo.feign.channel.IProductDailyRateClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IProductDailyRateClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:25
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IProductDailyRateClientFeign extends IProductDailyRateClient {
}
