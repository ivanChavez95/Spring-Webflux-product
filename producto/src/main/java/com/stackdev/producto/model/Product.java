package com.stackdev.producto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer idProducto;
    private String nombreProducto;
    private Float saldoProducto;

}
