package com.zzr.apollo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author ZhouZhiRui
 * @since 2022/11/25 17:43
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.zzr.apollo.mapper")
public class ZzrSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzrSystemApplication.class, args);
    }
}
