package com.manojtechie.order_service.feignClient;

import com.manojtechie.order_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name ="inventory-service",url = "http://localhost:8083/api/inventory")
public interface InventoryFeignClient {

    @GetMapping("/{skuCode}")

    List<InventoryResponse> isInStock(@RequestParam List<String> skuCode);


}
