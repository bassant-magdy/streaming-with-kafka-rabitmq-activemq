package com.abani.distributed.component.service;

import com.abani.distributed.component.model.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);


    /*
    * Apache Kafka has a dedicated and fundamental unit for Event or Message organization, called Topics.
    * Topics are Virtual Groups or Logs that hold messages and events in a logical order,
    * allowing users to send and receive data between Kafka Servers with ease.
    */
    @Value("${spring.kafka.producer.topic.message}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, MessageItem> kafkaTemplate;

    public void send(MessageItem messageItem){
        LOG.info("Sent By Kafka");
        kafkaTemplate.send(topic, messageItem);
    }
}
