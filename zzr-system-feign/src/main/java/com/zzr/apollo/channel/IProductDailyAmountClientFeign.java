package com.zzr.apollo.channel;

import com.zzr.apollo.feign.channel.IProductDailyAmountClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IProductDailyAmountClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:11
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IProductDailyAmountClientFeign extends IProductDailyAmountClient {
}
