package com.bitcamp.web.mapper;

import java.util.List;

import com.bitcamp.web.domain.CategoriesDTO;

import org.springframework.stereotype.Repository;

/**
 * CategoriesDTO
 */
@Repository
public interface CategoriesMapper {
        
    public void insertCategory(CategoriesDTO category);

    public List<CategoriesDTO> selectCategories();

    public List<CategoriesDTO> selectCategoriesByWord(CategoriesDTO category);

    public CategoriesDTO selectCategoryById(CategoriesDTO category);

    public void updateCategory(CategoriesDTO category);

    public void deleteCategory(CategoriesDTO category);
    
}