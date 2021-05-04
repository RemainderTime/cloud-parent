package com.xf.cloud.cloudsystem.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud-parent
 * @description: 10.2 使用@SentinelRestTemplate来包装下RestTemplate实例
 * @author: xf
 * @create: 2021-05-04 22:17
 **/
@Configuration
public class RibbonConfig {

    @Bean
    @SentinelRestTemplate
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}