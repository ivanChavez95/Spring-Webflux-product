package com.nttdata.product.repository;

import com.nttdata.product.model.document.ProductModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductModel, String> {

}
