package com.bitcamp.web.mapper;

import java.util.List;

import com.bitcamp.web.domain.ShippersDTO;

import org.springframework.stereotype.Repository;

/**
 * ShippersMapper
 */
@Repository
public interface ShippersMapper {
    public void insertShippers(ShippersDTO shippers);

    public List<ShippersDTO> selectShippers();

    public List<ShippersDTO> selectShippersByWord(ShippersDTO shippers);

    public ShippersDTO selectShippersById(ShippersDTO shippers);

    public void updateShippers(ShippersDTO shippers);

    public void deleteShippers(ShippersDTO shippers);
    
}