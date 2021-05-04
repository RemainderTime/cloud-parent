package com.xf.cloud.cloudbase.mq;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @program: cloud-parent
 * @description: 用户消息消费者监控器类
 * @author: xf
 * @create: 2021-04-11 13:43
 **/
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "receive_user_consumer_group",topic = "USER_SEND_MESSAGE_TOPIC_T")
public class ReceiveUserConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("---------用户消费者开始消费----------");
        JSONObject data = JSONObject.parseObject(s);
        String message = (String) data.get("message");
        log.info("---------用户消费者开始完成----------"+message);
    }
}
