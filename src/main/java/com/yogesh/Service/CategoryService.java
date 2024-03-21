package com.yogesh.Service;

import com.yogesh.model.Category;

import java.util.List;

public interface CategoryService {
    public Category createcategory(String name,Long userId) throws Exception;

    public List<Category> findCategoryByRestaurantId(Long id) throws Exception;

    public Category findCategoryById(Long id) throws Exception;


}
