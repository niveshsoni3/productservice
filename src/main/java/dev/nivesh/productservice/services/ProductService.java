package dev.nivesh.productservice.services;

import dev.nivesh.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto updateProductById(Long id, GenericProductDto productDto);
}
