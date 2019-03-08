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
public class EmailMqTopicListener {
    private static final Logger logger = LoggerFactory.getLogger(EmailMqTopicListener.class);

    @RabbitListener(queues = "emailqueue")
    @RabbitHandler
    public void getMsg(Message message){
        logger.debug("here emailqueue got message --------------------------------- :" + message);
    }
}
