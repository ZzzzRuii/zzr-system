package com.zzr.apollo.feign;

import com.zzr.apollo.feign.master.IFacadeClient;
import com.zzr.apollo.master.dto.CreateBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.vo.BookingMasterAndItemFacadeVO;
import com.zzr.apollo.service.IBookingMasterAndItemFacadeService;
import com.zzr.base.api.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FacadeClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 14:58
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class FacadeClient implements IFacadeClient {

    private final IBookingMasterAndItemFacadeService service;


    /**
     * 查询
     *
     * @param dto
     * @return
     */
    @Override
    public R<List<BookingMasterAndItemFacadeVO>> selectTree(QueryBookingMasterAndItemFacadeDTO dto) {
        return R.data(service.selectTree(dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @Override
    public R<BookingMasterAndItemFacadeVO> create(CreateBookingMasterAndItemFacadeDTO dto) {
        return R.data(service.create(dto));
    }
}
