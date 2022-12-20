package forkjoin.glucosemonitor.repository;

import forkjoin.glucosemonitor.dto.ProductDto;
import forkjoin.glucosemonitor.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByName(String name);
}
