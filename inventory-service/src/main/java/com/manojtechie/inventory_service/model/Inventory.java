package com.manojtechie.inventory_service.model;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;   
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.GenerationType;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;

}
