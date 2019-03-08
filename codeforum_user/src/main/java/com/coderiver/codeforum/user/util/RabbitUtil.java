package com.coderiver.codeforum.user.util;

import com.coderiver.codeforum.common.entity.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
public class RabbitUtil {

    public static void sendMessge2Rabbit(RabbitTemplate rabbitTemplate, String targetExchange, String targetTopic, Message message){
        rabbitTemplate.convertAndSend(targetExchange, targetTopic, message);
    }
}
