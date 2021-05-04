package com.xf.cloud.cloudsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.xf.cloud.cloudsystem.consumer.BaseConsumerSystem;
import com.xf.cloud.cloudsystem.entity.User;
import com.xf.cloud.cloudsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
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

    @Autowired
    private UserService userService;

    @Autowired
    private BaseConsumerSystem baseConsumerSystem;

    //9.mq
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @ApiOperation(value = "获取用户信息",notes = "/",httpMethod = "GET")
    @ApiImplicitParam(dataType = "long",name = "id",value = "id",required = true)
    @RequestMapping(value = "/getName")
    public String getUser(String id){
        User user = userService.getById(id);
        return "Hello "+user.getUserName();
    }

    @ApiOperation(value = "远程调用base服务获取用户信息",notes = "/",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "name",value = "姓名",required = true)
    @RequestMapping(value = "/info")
    public String getInfo(String name){
        return baseConsumerSystem.getUserInfo(name);
    }

    /**
     * 9. 发送mq消息
     * @param message
     * @return
     */
    @ApiOperation(value = "9.发送mq消息",notes = "/",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "message",value = "信息内容化",required = true)
    @RequestMapping(value = "/sendMessageMq")
    public String sendMessageMq(String message){

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("message",message);
        String s = jsonObject.toJSONString();
        Message<String> msg = MessageBuilder.withPayload(s).build();
        rocketMQTemplate.sendMessageInTransaction("commit_user_producer_group","USER_SEND_MESSAGE_TOPIC_T",msg,null);

        return "发送成功";
    }
}
