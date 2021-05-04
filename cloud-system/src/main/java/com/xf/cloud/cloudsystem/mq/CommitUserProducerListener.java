package com.xf.cloud.cloudsystem.mq;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "commit_user_producer_group")
public class CommitUserProducerListener implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {

        //进行幂等性判断业务...

        log.info("-----------用户生成者进行确认提交到mq中----------");
        return RocketMQLocalTransactionState.COMMIT;
    }

    //回滚方法
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {

        log.info("-----------用户生成者出现异常进行回滚事务----------");
        return RocketMQLocalTransactionState.UNKNOWN;
    }
}
