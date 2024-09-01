package com.ecommere.project.service;

import com.ecommere.project.model.Category;
import com.ecommere.project.payload.CategoryDTO;
import com.ecommere.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO,Long categoryId);

}
