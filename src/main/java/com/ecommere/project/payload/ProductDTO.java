package com.ecommere.project.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must be atleast 3 character!!")
    private String productName;
    @NotBlank
    @Size(min = 20, message = "Description must be atleast 20 character!!")
    private String description;
    private String image;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;
}
