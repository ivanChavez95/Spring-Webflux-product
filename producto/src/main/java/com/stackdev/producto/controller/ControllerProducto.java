package com.stackdev.producto.controller;
import java.math.BigDecimal;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class ControllerProducto {
    @GetMapping("/listarProductos")
    public Flux<BigDecimal> findAll() {
        return Flux.just(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN);
    }

}
