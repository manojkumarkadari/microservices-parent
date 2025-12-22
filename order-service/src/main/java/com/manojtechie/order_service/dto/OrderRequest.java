package com.manojtechie.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {
    private Integer quantity;
    private Integer totalPrice;
    private java.util.List<OrderLineItemsDto> orderLineItemsDtoList;


}
