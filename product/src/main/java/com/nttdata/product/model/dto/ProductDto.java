package com.nttdata.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDto {
    private String name;
    private BigDecimal balance;
    private BigDecimal debt;
}
