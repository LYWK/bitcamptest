package com.bitcamp.web.serviceImpl;

import java.util.List;

import com.bitcamp.web.domain.CategoriesDTO;
import com.bitcamp.web.service.CategoriesService;

import org.springframework.stereotype.Service;

/**
 * CategoriesServiceImpl
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Override
    public void addCategory(CategoriesDTO category) {

    }

    @Override
    public List<CategoriesDTO> findCategories() {
        return null;
    }

    @Override
    public List<CategoriesDTO> findCategoriesByWord(CategoriesDTO category) {
        return null;
    }

    @Override
    public CategoriesDTO findCategoryById(CategoriesDTO category) {
        return null;
    }

    @Override
    public void updateCategory(CategoriesDTO category) {

    }

    @Override
    public void deleteCategory(CategoriesDTO category) {

    }

    
}