package com.bitcamp.web.service;

import java.util.List;

import com.bitcamp.web.domain.ProductDTO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Component
public interface ProductService {
    public void addProduct(ProductDTO product);

    public List<ProductDTO> findProduct();

    public List<ProductDTO> findProductByWord(ProductDTO product);

    public ProductDTO findProductById(ProductDTO product);

    public void updateProduct(ProductDTO product);

    public void deleteProduct(ProductDTO product);
    
}