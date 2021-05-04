package com.xf.cloud.cloudsystem.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xf.cloud.cloudsystem.model.ResponseResult;

/**
 * @program: cloud-parent
 * @description: 10. 自定义限流逻辑
 * @author: xf
 * @create: 2021-05-04 22:01
 **/
public class CustomBlockHandler {


    public ResponseResult handleException(BlockException exception){
        return new ResponseResult(200,"自定义限流信息");
    }
}
