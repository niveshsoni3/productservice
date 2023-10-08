package dev.nivesh.productservice.controllers;

import dev.nivesh.productservice.dtos.GenericCategoryDto;
import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.exceptions.NotFoundException;
import dev.nivesh.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    private CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<GenericCategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("{name}")
    public List<GenericProductDto> getAllProductsbyCategory(@PathVariable("name") String name) throws NotFoundException {
        return categoryService.getAllProductsbyCategory(name);
    }
}
