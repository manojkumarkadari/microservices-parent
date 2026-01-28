package com.manojtechie.order_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDTO  extends OrderRequest{
    public static final DateTimeFormatter EVENT_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE;
    private String OrderId;

}
