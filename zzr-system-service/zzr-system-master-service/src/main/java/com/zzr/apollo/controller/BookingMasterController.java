package com.zzr.apollo.controller;

import com.zzr.apollo.api.R;
import com.zzr.apollo.master.dto.CreateBookingMasterDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterDTO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.wrapper.BookingMasterWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 主订单 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:37
 */
@RestController
@AllArgsConstructor
@Api(value = "主订单")
@RequestMapping("/master")
public class BookingMasterController {

    private final IBookingMasterService bookingMasterService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query         分页
     * @param bookingMaster
     */
    @GetMapping
    @ApiOperation(value = "查询BookingMaster列表")
    public R<Page<BookingMasterVO>> selectPage(Query query, QueryBookingMasterDTO bookingMaster) {
        try {
            Page<BookingMasterVO> bookingMasterPage = bookingMasterService.selectPage(query, bookingMaster);

            return R.data(bookingMasterPage);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 创建对象BookingMaster
     *
     * @param bookingMaster
     * @return 主订单id
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingMaster")
    public R<Long> create(@RequestBody @Validated CreateBookingMasterDTO bookingMaster) {
        try {
            BookingMasterDO bookingMasterDO = bookingMasterService.create(bookingMaster);

            return R.data(bookingMasterDO.getId());
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingMaster详情")
    public R<BookingMasterVO> detail(@PathVariable("id") Long id) {
        try {
            BookingMasterDO entity = bookingMasterService.detail(id);
            BookingMasterVO vo = BookingMasterWrapper.build().entityVO(entity);

            return R.data(vo);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }


    /**
     * 根据Id 更新 BookingMaster对象
     *
     * @param id
     * @param bookingMaster
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingMaster")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterDTO bookingMaster) {
        try {
            Boolean result = bookingMasterService.update(bookingMaster, id);

            return R.data(result);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }


    /**
     * 根据id删除BookingMaster
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingMaster")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        try {
            Boolean result = bookingMasterService.deleteById(id);

            return R.data(result);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 预付款
     *
     * @param id 主键
     */
    @PutMapping("/{id}/reserve")
    @ApiOperation(value = "预付款BookingMaster")
    public R<Boolean> reserve(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.reserve(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 已付款
     *
     * @param id 主键
     */
    @PutMapping("/{id}/rePay")
    @ApiOperation(value = "已付款BookingMaster")
    public R<Boolean> rePay(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.rePay(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 已取消
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/canceled")
    @ApiOperation(value = "已取消BookingMaster")
    public R<Boolean> canceled(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.canceled(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 确认中
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/confirming")
    @ApiOperation(value = "确认中BookingMaster")
    public R<Boolean> confirming(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.confirming(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 已确认
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/confirmed")
    @ApiOperation(value = "已确认BookingMaster")
    public R<Boolean> confirmed(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.confirmed(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 执行中
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/doing")
    @ApiOperation(value = "执行中BookingMaster")
    public R<Boolean> doing(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.doing(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据主键 完成
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/complete")
    @ApiOperation(value = "完成BookingMaster")
    public R<Boolean> complete(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterService.complete(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

}
