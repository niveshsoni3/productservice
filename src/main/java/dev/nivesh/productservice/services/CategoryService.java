package dev.nivesh.productservice.services;

import dev.nivesh.productservice.dtos.GenericCategoryDto;
import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.exceptions.NotFoundException;

import java.util.List;

public interface CategoryService {
    List<GenericCategoryDto> getAllCategories();


    List<GenericProductDto> getAllProductsbyCategory(String name) throws NotFoundException;
}
