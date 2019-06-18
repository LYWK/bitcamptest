package com.bitcamp.web.serviceImpl;

import java.util.List;

import com.bitcamp.web.domain.ProductDTO;
import com.bitcamp.web.service.ProductService;

import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(ProductDTO Product) {

    }

    @Override
    public List<ProductDTO> findProduct() {
        return null;
    }

    @Override
    public List<ProductDTO> findProductByWord(ProductDTO Product) {
        return null;
    }

    @Override
    public ProductDTO findProductById(ProductDTO Product) {
        return null;
    }

    @Override
    public void updateProduct(ProductDTO Product) {

    }

    @Override
    public void deleteProduct(ProductDTO Product) {

    }

    
}