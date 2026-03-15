package ap2._6.nori.cuya.repository;


import ap2._6.nori.cuya.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}