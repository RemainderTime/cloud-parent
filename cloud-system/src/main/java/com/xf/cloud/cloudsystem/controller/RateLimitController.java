package com.xf.cloud.cloudsystem.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xf.cloud.cloudsystem.handler.CustomBlockHandler;
import com.xf.cloud.cloudsystem.model.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-parent
 * @description: 10. 测试熔断和限流功能控制器
 * @author: xf
 * @create: 2021-05-04 21:20
 **/
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public ResponseResult byResource() {
        return new ResponseResult(200,"按资源名称限流");
    }

    /**
     * 按URL限流，有默认的限流处理逻辑
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleException")
    public ResponseResult byUrl() {
        return new ResponseResult(200,"按url限流");
    }

    public ResponseResult handleException(BlockException exception){
        return new ResponseResult(200,exception.getClass().getCanonicalName());
    }


    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandler = "handleException",blockHandlerClass = CustomBlockHandler.class)
    public ResponseResult blockHandler() {
        return new ResponseResult(200,"限流成功");
    }
}
