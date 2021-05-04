package com.xf.cloud.cloudbase.provider;

import com.xf.cloud.cloudbase.api.UserApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-parent
 * @description: 提供外部服务调用实现
 * @author: xf
 * @create: 2021-03-23 23:18
 **/
@RestController
public class UserProvider implements UserApi {
    @Override
    public String getUserInfo(String name) {
        return name+"，成功的使用openfeign调用了一个base服务";
    }
}
