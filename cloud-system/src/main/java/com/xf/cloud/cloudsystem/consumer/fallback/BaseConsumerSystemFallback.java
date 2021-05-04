package com.xf.cloud.cloudsystem.consumer.fallback;

import com.xf.cloud.cloudsystem.consumer.BaseConsumerSystem;
import com.xf.cloud.cloudsystem.model.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: cloud-parent
 * @description: base服务降级处理类
 * @author: xf
 * @create: 2021-03-23 23:25
 **/
@Component
public class BaseConsumerSystemFallback implements BaseConsumerSystem {
    @Override
    public String getUserInfo(String name) {
        return "进行降级处理";
    }

    @Override
    public ResponseResult breaker() {
        return new ResponseResult(200,"sentinel降级处理成功");
    }
}
