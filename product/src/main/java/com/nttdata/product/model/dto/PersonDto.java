package com.nttdata.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends ClientDto{
    /**
     * Registra el apellido del cliente
     * */
    private String lastName;
}
