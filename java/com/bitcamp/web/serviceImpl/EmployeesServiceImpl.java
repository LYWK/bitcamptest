package com.bitcamp.web.serviceImpl;

import java.util.List;

import com.bitcamp.web.domain.EmployeesDTO;
import com.bitcamp.web.service.EmployeesService;

import org.springframework.stereotype.Service;

/**
 * EmployeesServiceImpl
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Override
    public void addEmployees(EmployeesDTO employees) {

    }

    @Override
    public List<EmployeesDTO> findEmployees() {
        return null;
    }

    @Override
    public List<EmployeesDTO> findEmployeesByWord(EmployeesDTO employees) {
        return null;
    }

    @Override
    public EmployeesDTO findEmployeesById(EmployeesDTO employees) {
        return null;
    }

    @Override
    public void updateEmployees(EmployeesDTO employees) {

    }

    @Override
    public void deleteEmployees(EmployeesDTO employees) {

    }


    
}