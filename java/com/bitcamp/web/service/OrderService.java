package com.bitcamp.web.service;

import java.util.List;

import com.bitcamp.web.domain.OrderDTO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * OrderService
 */
@Component
public interface OrderService {
    public void addOrder(OrderDTO Oder);

    public List<OrderDTO> findOder();

    public List<OrderDTO> findOderByWord(OrderDTO Oder);

    public OrderDTO findOderById(OrderDTO Oder);

    public void updateOder(OrderDTO Oder);

    public void deleteOder(OrderDTO Oder);
    
}