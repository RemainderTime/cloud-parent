package com.xf.cloud.cloudsystem.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xf.cloud.cloudsystem.entity.User;
import com.xf.cloud.cloudsystem.model.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud-parent
 * @description: 10.2 熔断器功能控制器
 * @author: xf
 * @create: 2021-05-04 22:21
 **/
@RestController
@RequestMapping("/breaker")
public class CircleBreakerController {

    private Logger LOGGER = LoggerFactory.getLogger(CircleBreakerController.class);
    @Autowired
    private RestTemplate restTemplate;
    private String userServiceUrl = "https://localhost:10086";

    @RequestMapping("/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handleFallback")
    public ResponseResult fallback(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", ResponseResult.class, id);
    }

    @RequestMapping("/fallbackException/{id}")
    @SentinelResource(value = "fallbackException",fallback = "handleFallback2", exceptionsToIgnore = {NullPointerException.class})
    public ResponseResult fallbackException(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", ResponseResult.class, id);
    }

    public ResponseResult handleFallback(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new ResponseResult(200,defaultUser,"服务降级返回");
    }

    public ResponseResult handleFallback2(@PathVariable Long id, Throwable e) {
        LOGGER.error("handleFallback2 id:{},throwable class:{}", id, e.getClass());
        User defaultUser = new User(-2L, "defaultUser2", "123456");
        return new ResponseResult(200,defaultUser,"服务降级返回");
    }
}
