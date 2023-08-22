package com.abani.distributed.component.service;

import com.abani.distributed.component.model.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQProducerService {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveMQProducerService.class);

    @Value("${spring.activemq.queueName}")
    private String queueName;

    // The JmsTemplate class handles the creation and
    // release of resources when sending or synchronously receiving messages.
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(MessageItem message){
        LOG.info("Sent by ActiveMQ");
        jmsTemplate.convertAndSend(queueName, message);
    }

}
