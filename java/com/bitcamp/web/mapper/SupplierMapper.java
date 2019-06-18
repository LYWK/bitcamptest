package com.bitcamp.web.mapper;

import java.util.List;

import com.bitcamp.web.domain.SupplierDTO;

import org.springframework.stereotype.Repository;

/**
 * SupplierMapper
 */
@Repository
public interface SupplierMapper {
    public void insertSupplier(SupplierDTO supplier);

    public List<SupplierDTO> selectSupplier();

    public List<SupplierDTO> selectSupplierByWord(SupplierDTO supplier);

    public SupplierDTO selectSupplierById(SupplierDTO supplier);

    public void updateSupplier(SupplierDTO supplier);

    public void deleteSupplier(SupplierDTO supplier);
    
}