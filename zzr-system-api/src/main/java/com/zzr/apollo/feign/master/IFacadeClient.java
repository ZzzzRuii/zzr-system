package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.vo.BookingMasterAndItemFacadeVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * IFacadeClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:00
 */
public interface IFacadeClient {
    /**
     * 查询
     *
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_FACADE)
    R<List<BookingMasterAndItemFacadeVO>> selectTree(@SpringQueryMap QueryBookingMasterAndItemFacadeDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_FACADE)
    R<BookingMasterAndItemFacadeVO> create(@RequestBody CreateBookingMasterAndItemFacadeDTO dto);
}
