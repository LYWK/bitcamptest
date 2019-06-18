package com.bitcamp.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * CategoriesDTO
 
      pojo  형태의  class
 */

@Data   @Component @Lazy
public class CategoriesDTO {
    public  String  categoryId,
                    categoryName,
                    description;  
    
}