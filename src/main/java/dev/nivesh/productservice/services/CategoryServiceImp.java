package dev.nivesh.productservice.services;

import dev.nivesh.productservice.dtos.GenericCategoryDto;
import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.exceptions.NotFoundException;
import dev.nivesh.productservice.models.Category;
import dev.nivesh.productservice.models.Product;
import dev.nivesh.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public GenericCategoryDto convertCategoryToGenericCategoryDto(Category category){
        GenericCategoryDto genericCategoryDTO = new GenericCategoryDto();
        genericCategoryDTO.setName(category.getName());
        return genericCategoryDTO;
    }
    private GenericProductDto convertProductIntoGenericProduct(Product product){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setImage(product.getImage());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setPrice(product.getPrice().getPrice());
        genericProductDto.setCategory(product.getCategory().getName());
        return genericProductDto;
    }
    @Override
    public List<GenericCategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<GenericCategoryDto> allCategories = new ArrayList<>();
        for(Category category : categories){
            allCategories.add(convertCategoryToGenericCategoryDto(category));
        }
        return allCategories;
    }

    @Override
    public List<GenericProductDto> getAllProductsbyCategory(String name) throws NotFoundException {
        Optional<Category> category = categoryRepository.getCategoryByName(name);
        if (category.isEmpty()){
            throw new NotFoundException("Category with name: " + name + " doesn't exist.");
        }
        List<Product> productList = category.get().getProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product : productList){
            genericProductDtos.add(convertProductIntoGenericProduct(product));
        }
        return genericProductDtos;
    }


}
