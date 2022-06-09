package com.nttdata.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto extends ClientDto{
    /**
     * Registra el ruc de la empresa
     * */
    private String ruc;
}
