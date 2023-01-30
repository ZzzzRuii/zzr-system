package com.zzr.apollo;

import com.zzr.base.autoconfigure.ZzrApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

/**
 * 启动类
 *
 * @author ZhouZhiRui
 * @since 2022/11/25 17:43
 */
@Slf4j
@ZzrApplication
public class ZzrSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzrSystemApplication.class, args);
    }
}
