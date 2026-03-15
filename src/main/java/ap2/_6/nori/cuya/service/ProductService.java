package ap2._6.nori.cuya.service;

import ap2._6.nori.cuya.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> findById(Long id);

    Mono<Product> save(Product product);

    Mono<Product> update(Long id, Product product);

    Mono<Void> delete(Long id);

}