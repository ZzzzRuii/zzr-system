package com.zzr.apollo.channel;

import com.zzr.apollo.feign.channel.IChannelClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IChannelClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/6 17:00
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IChannelClientFeign extends IChannelClient {
}
