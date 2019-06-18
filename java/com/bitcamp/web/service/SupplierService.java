package com.bitcamp.web.service;

import java.util.List;

import com.bitcamp.web.domain.SupplierDTO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * SupplierService
 */
@Component
public interface SupplierService {
    public void addSupplier(SupplierDTO supplier);

    public List<SupplierDTO> findSupplier();

    public List<SupplierDTO> findSupplierByWord(SupplierDTO supplier);

    public SupplierDTO findSupplierById(SupplierDTO supplier);

    public void updateSupplier(SupplierDTO supplier);

    public void deleteSupplier(SupplierDTO supplier);
    
}