package com.zzr.base.autoconfigure;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * ZzrApplication
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/30 11:23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
@ComponentScan("com.zzr")
@EnableFeignClients({"com.zzr"})
public @interface ZzrApplication {
}
