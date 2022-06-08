package com.nttdata.product.controller;

import com.nttdata.product.service.ProductService;
import com.nttdata.product.model.document.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class Productcontroller {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Mono<ResponseEntity<Flux<ProductModel>>> listProducts(){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(productService.findAll())
        );
    }

    @PostMapping("/createProductActive")
    public Mono<ResponseEntity<Map<String, Object>>> createProductActive(@Valid @RequestBody Mono<ProductModel> monoProduct){
        Map<String, Object> result = new HashMap<>();

        return monoProduct.flatMap(productModel -> {
            return productService.createProductActive(productModel).map(c -> {
                result.put("product",c);
                result.put("message","Active Product Saved Successfully");
                result.put("timestamp",new Date());
                return ResponseEntity
                        .created(URI.create("api/product/"+ c.getProductId()))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(result);
            });
        }).onErrorResume(t -> {
            return Mono.just(t).cast(WebExchangeBindException.class)
                    .flatMap(e -> Mono.just(e.getFieldErrors()))
                    .flatMapMany(Flux::fromIterable)
                    .map(fieldError -> "The Entry: " + fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .collectList()
                    .flatMap(list -> {
                        result.put("errors", list);
                        result.put("timestamp",new Date());
                        result.put("status", HttpStatus.BAD_REQUEST.value());

                        return Mono.just(ResponseEntity.badRequest().body(result));
                    });
        });
    }
    @PostMapping("/createProductPassive")
    public Mono<ResponseEntity<Map<String, Object>>> createProductPassive(@Valid @RequestBody Mono<ProductModel> monoProduct){
        Map<String, Object> result = new HashMap<>();

        return monoProduct.flatMap(productModel -> {
            return productService.createProductPassive(productModel).map(c -> {
                result.put("product",c);
                result.put("message","Active Product Saved Successfully");
                result.put("timestamp",new Date());
                return ResponseEntity
                        .created(URI.create("api/product/"+ c.getProductId()))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(result);
            });
        }).onErrorResume(t -> {
            return Mono.just(t).cast(WebExchangeBindException.class)
                    .flatMap(e -> Mono.just(e.getFieldErrors()))
                    .flatMapMany(Flux::fromIterable)
                    .map(fieldError -> "The Entry: " + fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .collectList()
                    .flatMap(list -> {
                        result.put("errors", list);
                        result.put("timestamp",new Date());
                        result.put("status", HttpStatus.BAD_REQUEST.value());

                        return Mono.just(ResponseEntity.badRequest().body(result));
                    });
        });
    }
    @GetMapping("/listProductsByPerson/{id}")
    public Mono<ResponseEntity<Flux<ProductModel>>> listProductsByPerson(String id){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(productService.getProductsByPerson(id))
        );
    }

    @GetMapping("/listProductsByCompany/{id}")
    public Mono<ResponseEntity<Flux<ProductModel>>> listProductsByCompany(String id){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(productService.getProductsByCompany(id))
        );
    }
    @PutMapping(path = "/updateBalance/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<ProductModel>> updateBalance(@PathVariable String id,@RequestBody ProductModel product){
        return productService.updateProductBalance(id).flatMap(
                c -> {
                    c.setBalance(product.getBalance());
                    return productService.createProductActive(c);
                }
        ).map(c -> ResponseEntity.created(URI.create("/api/product/".concat(c.getProductId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
