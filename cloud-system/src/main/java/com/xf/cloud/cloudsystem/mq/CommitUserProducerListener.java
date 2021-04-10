package com.xf.cloud.cloudsystem.mq;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @program: cloud-parent
 * @description: 用户消息生产者提交类
 * @author: xf
 * @create: 2021-04-11 00:01
 **/
@RocketMQTransactionListener(txProducerGroup = "commit_user_producer_listener")
public class CommitUserProducerListener implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        return null;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return null;
    }
}
