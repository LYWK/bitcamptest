package com.bitcamp.web.service;

import java.util.List;

import com.bitcamp.web.domain.ShippersDTO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ShippersService
 */
@Component
public interface ShippersService {
    public void addShippers(ShippersDTO shippers);

    public List<ShippersDTO> findShippers();

    public List<ShippersDTO> findShippersByWord(ShippersDTO shippers);

    public ShippersDTO findShippersById(ShippersDTO shippers);

    public void updateShippers(ShippersDTO shippers);

    public void deleteShippers(ShippersDTO shippers);
    
}