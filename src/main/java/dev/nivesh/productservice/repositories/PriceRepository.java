package dev.nivesh.productservice.repositories;

import dev.nivesh.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
    public Optional<Price> findByPrice(Double price);
}
