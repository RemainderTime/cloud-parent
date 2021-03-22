package com.xf.cloud.cloudsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-parent
 * @description: 用户控制层
 * @author: xf
 * @create: 2021-03-21 21:26
 **/

@RestController
@Api(value = "用户基本信息",tags = "用户基本信息接口")
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "获取用户信息",notes = "/",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "name",value = "姓名",required = true)
    @RequestMapping(value = "/info")
    public String getUser(String name){
        return "Hello "+name;
    }
}
