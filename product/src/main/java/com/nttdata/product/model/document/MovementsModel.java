package com.nttdata.product.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MovementsModel {
    private Date movementDate;
    private String movement;
}
