package com.nttdata.product.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String name;
    private BigDecimal balance;
    private BigDecimal debt;
}
