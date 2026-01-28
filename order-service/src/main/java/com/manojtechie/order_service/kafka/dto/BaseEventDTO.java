package com.manojtechie.order_service.kafka.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.manojtechie.order_service.kafka.EventStatus;
import com.manojtechie.order_service.utils.EventUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.ZonedDateTime;

@SuppressWarnings("serial")
@Getter 
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,include = JsonTypeInfo.As.PROPERTY,property = "@class")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEventDTO implements Serializable {

    private int maxAttempts;
    private int currentCount;
    private long delay;
    private String correlationId;
    private String eventType;
    private String entity;
    private String country;
    private boolean processStatus;
    private String errorMessage;
    private long eventCreatedTime;
    private long receivedTime;
    private int maxPartitions;
    private long eventTransactionId;
    private ZonedDateTime eventReceivedTime;
    private String userId;

    @JsonIgnore
    private boolean dBCacheEnabled;


    private EventStatus eventStatus = EventStatus.MESSAGE_CREATED;

    public String toJSONString(){
        try{
            return EventUtils.eventSerializer.serialize(this);
        }catch(Exception e){
            return super.toString();
        }
    }

    


}
