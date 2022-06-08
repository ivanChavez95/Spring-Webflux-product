package com.nttdata.product.model.request;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private Integer idProduct;

    private String description;
}
