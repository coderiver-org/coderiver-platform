package com.coderiver.codeforum.message.listener;

import com.coderiver.codeforum.common.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
@Component
public class SmsMqTopicListener {
    private static final Logger logger = LoggerFactory.getLogger(SmsMqTopicListener.class);

    @RabbitListener(queues = "smsqueue")
    @RabbitHandler
    public void getMsg(Message message){
        logger.debug("here smsqueue got message ------------------------- :" + message);
    }
}
