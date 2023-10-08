package dev.nivesh.productservice.services;

import dev.nivesh.productservice.dtos.GenericProductDto;
import dev.nivesh.productservice.exceptions.NotFoundException;
import dev.nivesh.productservice.models.Category;
import dev.nivesh.productservice.models.Price;
import dev.nivesh.productservice.models.Product;
import dev.nivesh.productservice.repositories.CategoryRepository;
import dev.nivesh.productservice.repositories.PriceRepository;
import dev.nivesh.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("selfProductServiceImp")
public class SelfProductServiceImp implements ProductService{
    private ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public SelfProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository,
                                 PriceRepository priceRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
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
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("Product with id: " + id + " doesn't exist.");
        }
        return convertProductIntoGenericProduct(product.get());
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setTitle(genericProductDto.getTitle());
        product.setDescription(genericProductDto.getDescription());
        product.setImage(genericProductDto.getImage());

        Category category = null;
        if (this.categoryRepository.findByName(genericProductDto.getCategory()).isEmpty()) {
            category = new Category();
            category.setName(genericProductDto.getCategory());
        }
        product.setCategory(category);

        Price price = null;
        if (this.priceRepository.findByPrice(genericProductDto.getPrice()).isEmpty()){
            price = new Price();
            price.setPrice(genericProductDto.getPrice());
            price.setCurrency("Rupee");
        }
        product.setPrice(price);
        Product product1 = productRepository.save(product);
        return convertProductIntoGenericProduct(product1);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> AllProducts = new ArrayList<>();
        for(Product product : products){
            AllProducts.add(convertProductIntoGenericProduct(product));
        }
        return AllProducts;
    }

    @Override
    public GenericProductDto deleteProduct(UUID id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("Product with id: " + id + " doesn't exist.");

        productRepository.delete(product.get());
        return convertProductIntoGenericProduct(product.get());
    }
    @Override
    public GenericProductDto updateProductById(UUID id, GenericProductDto genericProductDto) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("Product with id: " + id + " doesn't exist.");
        }
        Product updatedProd = product.get();
        updatedProd.setTitle(genericProductDto.getTitle());
        updatedProd.setDescription(genericProductDto.getDescription());
        updatedProd.setImage(genericProductDto.getImage());
        Price price = new Price("Rupee", genericProductDto.getPrice());
        updatedProd.setPrice(price);
        Category category = new Category();
        category.setName(genericProductDto.getCategory());
        updatedProd.setCategory(category);

        Product product1 = productRepository.save(updatedProd);
        return convertProductIntoGenericProduct(product1);
    }
}
