package spring.boot.crud.example.repository;

import spring.boot.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
}
