package com.bitcamp.web.mapper;

import java.util.List;

import com.bitcamp.web.domain.EmployeesDTO;

import org.springframework.stereotype.Repository;

/**
 * EmployeesMapper
 */
@Repository
public interface EmployeesMapper {
    public void insertEmployees(EmployeesDTO employees);

    public List<EmployeesDTO> selectEmployees();

    public List<EmployeesDTO> selectEmployeesByWord(EmployeesDTO employees);

    public EmployeesDTO selectEmployeesById(EmployeesDTO employees);

    public void updateEmployees(EmployeesDTO employees);

    public void deleteEmployees(EmployeesDTO employees);
    
}