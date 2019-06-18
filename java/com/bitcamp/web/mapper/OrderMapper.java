package com.bitcamp.web.mapper;

import java.util.List;

import com.bitcamp.web.domain.OrderDTO;

import org.springframework.stereotype.Repository;

/**
 * OrderMapper
 */
@Repository
public interface OrderMapper {
    public void insertOrder(OrderDTO Oder);

    public List<OrderDTO> selectOder();

    public List<OrderDTO> selectOderByWord(OrderDTO Oder);

    public OrderDTO selectOderById(OrderDTO Oder);

    public void updateOder(OrderDTO Oder);

    public void deleteOder(OrderDTO Oder);
    
}