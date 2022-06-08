package com.nttdata.product.service;

import com.nttdata.product.model.document.ProductModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductModel> findAll();
    Flux<ProductModel> getProductsByPerson(String id);
    Flux<ProductModel> getProductsByCompany(String id);
    Mono<ProductModel> createProductPassive(ProductModel body);
    Mono<ProductModel> createProductActive(ProductModel body);
    Mono<ProductModel> updateProductBalance(String id);
    Mono<Void> deleteProduct(String id);
}
