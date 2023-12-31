package dev.nivesh.productservice.repositories;

import dev.nivesh.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category , UUID> {

    public Optional<Category> findByName(String name);
    public Optional<Category> getCategoryByName(String name);
}
