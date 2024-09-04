package com.ecommere.project.service;
import com.ecommere.project.model.Product;
import com.ecommere.project.payload.ProductDTO;
import com.ecommere.project.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Product product, Long categoryId);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);
}
