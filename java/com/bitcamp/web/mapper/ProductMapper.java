package com.bitcamp.web.mapper;

import java.util.List;

import com.bitcamp.web.domain.ProductDTO;

import org.springframework.stereotype.Repository;

/**
 * ProductMapper
 */
@Repository
public interface ProductMapper {
    public void insertProduct(ProductDTO product);

    public List<ProductDTO> selectProduct();

    public List<ProductDTO> selectProductByWord(ProductDTO product);

    public ProductDTO selectProductById(ProductDTO product);

    public void updateProduct(ProductDTO product);

    public void deleteProduct(ProductDTO product);
    
}