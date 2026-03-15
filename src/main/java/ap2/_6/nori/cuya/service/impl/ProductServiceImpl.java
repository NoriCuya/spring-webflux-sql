package ap2._6.nori.cuya.service.impl;

import ap2._6.nori.cuya.model.Product;
import ap2._6.nori.cuya.repository.ProductRepository;
import ap2._6.nori.cuya.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Flux<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    @Override
    public Mono<Product> update(Long id, Product product) {
        return repository.findById(id)
                .flatMap(p -> {
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                    p.setStock(product.getStock());
                    p.setCategory(product.getCategory());
                    p.setBrand(product.getBrand());
                    return repository.save(p);
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }
}