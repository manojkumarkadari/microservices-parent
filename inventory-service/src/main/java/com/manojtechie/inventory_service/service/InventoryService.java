package com.manojtechie.inventory_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manojtechie.inventory_service.repository.InventoryRepository;

@Service
@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Boolean isInStock(String skuCode) {
        // Implementation logic to check inventory

        inventoryRepository.findBySkuCode(skuCode);


        return false; // Placeholder return value
    }
}
