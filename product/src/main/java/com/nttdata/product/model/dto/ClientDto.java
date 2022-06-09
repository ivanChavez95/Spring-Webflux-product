package com.nttdata.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ClientDto implements Serializable {
    private String id;
    /**
     * para la identificaion del dni o ruc
     * */
    private String identificaiton;

    /**
     * para el nombre del cliente
     * */
    private String name;

    /**
     * Guarda la fecha de crecion,
     * del registro
     * */
    private LocalDateTime createdAt;

    /**
     * Registra la modificaion del producto
     * */
    private LocalDateTime modifiedAt;

    /**
     * 0: inactivo
     * 1: activo
     * */
    private int state;

    public ClientDto(){
        createdAt=LocalDateTime.now();
        modifiedAt=LocalDateTime.now();
        state=1;
    }
}
