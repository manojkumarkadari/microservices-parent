package com.manojtechie.order_service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data; 


@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private Integer quantity;
    private BigDecimal price;
    

}
