package com.manojtechie.inventory_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manojtechie.inventory_service.dto.InventoryResponse;
import com.manojtechie.inventory_service.repository.InventoryRepository;
import java.util.List; 

@Service
@Transactional(readOnly = true)
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryResponse> isInStock(List<String> skuCode) {
        // Implementation logic to check inventory

        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
        .map(inventory ->InventoryResponse.builder()
        .skuCode(inventory.getSkuCode())
        .isInStock(inventory.getQuantity() > 0)
        .build()).toList();
    }
}
