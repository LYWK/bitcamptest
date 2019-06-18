package com.bitcamp.web.service;

import java.util.List;

import com.bitcamp.web.domain.EmployeesDTO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * EmployeesService
 */
@Component
public interface EmployeesService {
    public void addEmployees(EmployeesDTO employees);

    public List<EmployeesDTO> findEmployees();

    public List<EmployeesDTO> findEmployeesByWord(EmployeesDTO employees);

    public EmployeesDTO findEmployeesById(EmployeesDTO employees);

    public void updateEmployees(EmployeesDTO employees);

    public void deleteEmployees(EmployeesDTO employees);
    
}