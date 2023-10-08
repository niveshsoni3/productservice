package dev.nivesh.productservice.controllers;

import dev.nivesh.productservice.dtos.ExceptionDto;
import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.exceptions.NotFoundException;
import dev.nivesh.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    //field injection
//    @Autowired // not recommended
    private ProductService productService;

    // constructor injection
    public ProductController(@Qualifier("selfProductServiceImp") ProductService productService){
        this.productService = productService;
    }
    //setter injection
//    @Autowired // not recommended
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }
    @GetMapping("")
    public List<GenericProductDto> getAllProducts() throws NotFoundException {
        return productService.getAllProducts();
//        return List.of(
//                new GenericProductDto(),
//                new GenericProductDto()
//        );
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.getProductById(id);
        //return "Here is the Product id: " + id;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") UUID id) throws NotFoundException {
        // This is how status code can be manually set by server
        ResponseEntity<GenericProductDto> response =
                new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
        return response;
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
//        return "Created new product with name: " + product.getTitle();
//        return "Created new product with id: " + UUID.randomUUID();

    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable("id") UUID id, @RequestBody GenericProductDto product) throws NotFoundException {
        return productService.updateProductById(id, product);
    }


}
