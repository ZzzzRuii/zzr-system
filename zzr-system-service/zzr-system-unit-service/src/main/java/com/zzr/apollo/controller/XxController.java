package com.zzr.apollo.controller;

import com.zzr.apollo.dto.QueryXxDTO;
import com.zzr.apollo.service.impl.XxServiceImpl;
import com.zzr.apollo.vo.XxVO;
import com.zzr.base.api.Result;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * XxController
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 13:20
 */
@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
public class XxController {

    private final XxServiceImpl xxService;

    /**
     * 测试
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping()
    public Result<Page<XxVO>> test(Query query, QueryXxDTO dto) {
        return Result.success();
    }
}
