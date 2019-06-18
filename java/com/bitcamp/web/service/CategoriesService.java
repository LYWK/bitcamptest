package com.bitcamp.web.service;

import java.util.List;

import com.bitcamp.web.domain.CategoriesDTO;

import org.springframework.stereotype.Component;

/**
 * CategoriesService
 */
@Component
public interface CategoriesService {
        
    public void addCategory(CategoriesDTO category);

    public List<CategoriesDTO> findCategories();

    public List<CategoriesDTO> findCategoriesByWord(CategoriesDTO category);

    public CategoriesDTO findCategoryById(CategoriesDTO category);

    public void updateCategory(CategoriesDTO category);

    public void deleteCategory(CategoriesDTO category);


    
}