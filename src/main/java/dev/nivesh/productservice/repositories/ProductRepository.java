package dev.nivesh.productservice.repositories;

import dev.nivesh.productservice.models.Category;
import dev.nivesh.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByCategoryEquals(Category category);
}
