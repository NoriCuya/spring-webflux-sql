package ap2._6.nori.cuya.rest;

import ap2._6.nori.cuya.model.Product;
import ap2._6.nori.cuya.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRest {

    private final ProductService service;

    @GetMapping
    public Flux<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product product){
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable Long id, @RequestBody Product product){
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return service.delete(id);
    }

}