package com.manojtechie.order_service.kafka.handler;


import com.manojtechie.order_service.kafka.EventSerializer;
import com.manojtechie.order_service.kafka.dto.BaseEventDTO;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaProducerConfig {
    private final KafkaProperties kafkaProperties;
    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String,Object> props = defaultProducerProps();
        return new DefaultKafkaProducerFactory<>(props);
    }
    @Bean
    public ProducerFactory<String, BaseEventDTO> eventDTOProducerFactory(){
        Map<String,Object> props = defaultProducerProps();
        DefaultKafkaProducerFactory<String,BaseEventDTO> factoryNew = new DefaultKafkaProducerFactory<>(props, (Serializer) new StringSerializer(), (Serializer) new EventSerializer<>());
        return factoryNew;
    }

    private Map<String,Object> defaultProducerProps()
    {
        return kafkaProperties.buildProducerProperties();
    }
}
