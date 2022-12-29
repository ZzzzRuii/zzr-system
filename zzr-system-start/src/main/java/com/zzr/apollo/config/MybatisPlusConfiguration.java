package com.zzr.apollo.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.zzr.base.mp.injector.AppSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MybatisPlusConfiguration
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 14:34
 */
@AutoConfiguration
@MapperScan({"com.**.mapper.**"})
@EnableConfigurationProperties({MybatisPlusProperties.class})
public class MybatisPlusConfiguration implements WebMvcConfigurer {

    @Bean
    public ISqlInjector sqlInjector() {
        return new AppSqlInjector();
    }

    public MybatisPlusConfiguration() {
    }
}