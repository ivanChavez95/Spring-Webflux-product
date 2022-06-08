package com.nttdata.product.model.document;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "product")
public class ProductModel{
    @Id
    private String productId;
    @NotEmpty
    private String name;
    @NotNull
    private BigDecimal balance;
    @NotNull
    private String idClient;
    private ProductActiveModel productActiveModel;
    private ProductPassiveModel productPassiveModel;

    private List<MovementsModel> arrMovements;

}
