package com.nttdata.product.model.request;

import com.nttdata.product.model.document.ProductActiveModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreateProductActiveRequest {

    @Id
    private Integer productId;
    @NotEmpty
    private String name;
    @NotNull
    private BigDecimal balance;
    private Integer idClient;
    private ProductActiveModel productActiveModel;
}
