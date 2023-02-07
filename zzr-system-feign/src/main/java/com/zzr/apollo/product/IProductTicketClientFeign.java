package com.zzr.apollo.product;

import com.zzr.apollo.feign.product.IProductTicketClient;
import com.zzr.base.constants.ApplicationName;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IProductTicketClientFeign
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 11:08
 */
@FeignClient(ApplicationName.ZZR_SYSTEM)
public interface IProductTicketClientFeign extends IProductTicketClient {
}
