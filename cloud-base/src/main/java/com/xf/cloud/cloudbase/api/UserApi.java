package com.xf.cloud.cloudbase.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: cloud-parent
 * @description: 定义外部调用user接口
 * @author: xf
 * @create: 2021-03-23 23:15
 **/
public interface UserApi {

    @RequestMapping("/user/info")
    String getUserInfo(@RequestParam("name")String name);
}
