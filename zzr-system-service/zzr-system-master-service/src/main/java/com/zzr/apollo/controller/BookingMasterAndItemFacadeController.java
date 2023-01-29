package com.zzr.apollo.controller;

import com.zzr.apollo.master.dto.CreateBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.vo.BookingMasterAndItemFacadeVO;
import com.zzr.apollo.service.IBookingMasterAndItemFacadeService;
import com.zzr.base.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单合并控制类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:36
 */
@RestController
@AllArgsConstructor
@Api(value = "订单合并")
@RequestMapping("/facade")
public class BookingMasterAndItemFacadeController {

    private final IBookingMasterAndItemFacadeService facadeService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param facadeDTO
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询BookingMasterAndItemFacade列表")
    public R<List<BookingMasterAndItemFacadeVO>> selectTree(QueryBookingMasterAndItemFacadeDTO facadeDTO) {
        List<BookingMasterAndItemFacadeVO> facadeList = facadeService.selectTree(facadeDTO);

        return R.data(facadeList);
    }

    /**
     * 创建对象BookingMaster
     *
     * @param facadeDTO
     * @return
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingMasterAndItemFacade")
    public R<BookingMasterAndItemFacadeVO> create(@RequestBody @Validated CreateBookingMasterAndItemFacadeDTO facadeDTO) {
        BookingMasterAndItemFacadeVO facadeVO = facadeService.create(facadeDTO);

        return R.data(facadeVO);
    }
}

