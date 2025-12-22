package com.manojtechie.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private String orderNumber;
    private Integer quantity;
    private Integer totalPrice;
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}