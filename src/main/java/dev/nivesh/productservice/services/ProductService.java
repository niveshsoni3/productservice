package dev.nivesh.productservice.services;

import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(UUID id) throws NotFoundException;

    List<GenericProductDto> getAllProducts() throws NotFoundException;

    GenericProductDto deleteProduct(UUID id) throws NotFoundException;

    GenericProductDto updateProductById(UUID id, GenericProductDto productDto) throws NotFoundException;
}
