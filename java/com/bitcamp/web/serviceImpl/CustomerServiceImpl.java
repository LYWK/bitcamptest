package com.bitcamp.web.serviceImpl;

import java.util.List;

import com.bitcamp.web.domain.CustomerDTO;
import com.bitcamp.web.mapper.CustomerMapper;
import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustormerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    
    
    @Autowired CustomerMapper customerMapper;
   
   
    @Override
    public void addCustomer(CustomerDTO customer) {
        customerMapper.insertCustomer(customer);
    }

    @Override
    public List<CustomerDTO> findCustomer() {
        return null;
    }

    @Override
    public List<CustomerDTO> findCustomerByWord(CustomerDTO customer) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {

    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {

    }

    @Override
    public int countAll() {
        return customerMapper.selectCount();
    }

    @Override
    public CustomerDTO login(CustomerDTO customer) {
       System.out.println("controller   에서 넘어온 아이디" + customer.getCustomerId());
       System.out.println("controller   에서 넘어온 아이디" + customer.getPassword());
       CustomerDTO temp = customerMapper.login(customer);
       return temp;
    }



    
}