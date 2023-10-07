package dev.nivesh.productservice.dtos;

import dev.nivesh.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private Double price;
}
