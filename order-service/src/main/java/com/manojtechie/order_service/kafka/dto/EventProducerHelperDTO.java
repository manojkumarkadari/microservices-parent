package com.manojtechie.order_service.kafka.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventProducerHelperDTO {
    private Long eventId;
    private String topic;
    private BaseEventDTO event;
    private Integer maxPartitions;
}
