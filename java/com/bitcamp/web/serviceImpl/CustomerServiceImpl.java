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
        return customerMapper.selectCustomers();
    }

    @Override
    public List<CustomerDTO> findCustomerByWord(CustomerDTO customer) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(String customerId) {
        return customerMapper.selectCustomerByCustomerId(customerId);
    }

    @Override
    public int updateCustomer(CustomerDTO customer) {
            int res = customerMapper.updateCustomer(customer);
             if (res == 1) {
                 System.out.println("서비스 수정 성공");
             } else {
                 System.out.println("서비스 수정 실패");
             }
            return res;
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
            customerMapper.deleteCustomer(customer);
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