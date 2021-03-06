package com.xf.cloud.cloudsystem.consumer;

import com.xf.cloud.cloudsystem.consumer.fallback.BaseConsumerSystemFallback;
import com.xf.cloud.cloudsystem.model.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: cloud-parent
 * @description: base基础服务消费方
 * @author:  xf
 * @create: 2021-03-23 23:22
 **/
@FeignClient(value = "cloud-base",url = "localhost:10020",fallback = BaseConsumerSystemFallback.class)
public interface BaseConsumerSystem {

    @RequestMapping("/user/info")
    String getUserInfo(@RequestParam("name")String name);

    @RequestMapping("/user/breaker")
    ResponseResult breaker();
}
