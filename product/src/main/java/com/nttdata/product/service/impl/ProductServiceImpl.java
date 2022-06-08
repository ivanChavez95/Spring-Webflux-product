package com.nttdata.product.service.impl;

import com.nttdata.product.model.dto.ClientDto;
import com.nttdata.product.service.CompanyRestService;
import com.nttdata.product.service.PersonRestService;
import com.nttdata.product.service.ProductService;
import com.nttdata.product.model.document.ProductModel;
import com.nttdata.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Override
    public Flux<ProductModel> findAll() {
        return productRepository.findAll();
    }


    @Override
    public Flux<ProductModel> getProductsByPerson(String id) {
        return productRepository.findAll(Example.of(new ProductModel(null,null,null,id,null,null, null)));
    }

    @Override
    public Flux<ProductModel> getProductsByCompany(String id) {
        return productRepository.findAll(Example.of(new ProductModel(null,null,null,id,null,null, null)));
    }

    @Override
    public Mono<ProductModel> createProductPassive(ProductModel body) {
        return productRepository.save(body);
    }

    @Override
    public Mono<ProductModel> createProductActive(ProductModel body) {
        return productRepository.save(body);
    }

    @Override
    public Mono<ProductModel> updateProductBalance(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
