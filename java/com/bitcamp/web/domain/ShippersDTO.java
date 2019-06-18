package com.bitcamp.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Shippers
 */
@Data @Component @Lazy
public class ShippersDTO {
   private String   shipperId,
                    shipperName,
                    phone;
    
}