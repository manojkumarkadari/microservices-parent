package com.manojtechie.order_service.utils;

import com.manojtechie.order_service.kafka.EventSerializer;
import com.manojtechie.order_service.kafka.dto.BaseEventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventUtils {
public static EventSerializer<BaseEventDTO> eventSerializer =new EventSerializer();

}
