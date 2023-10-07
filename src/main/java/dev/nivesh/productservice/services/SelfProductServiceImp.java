package dev.nivesh.productservice.services;

import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImp")
public class SelfProductServiceImp implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) {
        return null;
    }
}
