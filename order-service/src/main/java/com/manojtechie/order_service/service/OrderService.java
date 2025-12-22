package com.manojtechie.order_service.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.manojtechie.order_service.model.Order;
import com.manojtechie.order_service.dto.OrderResponse;
import com.manojtechie.order_service.dto.OrderRequest;
import com.manojtechie.order_service.model.OrderLineItems;
import com.manojtechie.order_service.dto.OrderLineItemsDto;
import java.util.UUID;
import java.util.List;
import com.manojtechie.order_service.repository.OrderRepository;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // Business logic to process the order would go here
        Order order = new Order();
        order.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        order.setQuantity(orderRequest.getQuantity());
        order.setTotalPrice(orderRequest.getTotalPrice());
        List<OrderLineItems> items = orderRequest.getOrderLineItemsDtoList().stream()
                .map(dto -> {
                    OrderLineItems item = maptoDto(dto);
                    item.setOrder(order);
                    return item;
                }).toList();
        order.setOrderLineItems(items);

        orderRepository.save(order);
 
        System.out.println("Order placed with " + orderRequest.getOrderLineItemsDtoList().size() + " items.");
    }

    private OrderLineItems maptoDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::mapToOrderResponse).toList();
    }

//get Order By Id

public OrderResponse getOrderById(Long id) {
    Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    return mapToOrderResponse(order);
}

    private OrderResponse mapToOrderResponse(Order order) {
        return new OrderResponse(
            order.getId(),
            order.getOrderNumber(),
            order.getQuantity(),
            order.getTotalPrice(),
            order.getOrderLineItems().stream().map(this::mapToOrderLineItemsDto).toList()
        );
    }

    private OrderLineItemsDto mapToOrderLineItemsDto(OrderLineItems orderLineItems) {
        return new OrderLineItemsDto(
            orderLineItems.getId(),
            orderLineItems.getSkuCode(),
            orderLineItems.getQuantity(),
            orderLineItems.getPrice()
        );
    }

}
