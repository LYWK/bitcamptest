package com.bitcamp.web.controller;

import java.util.HashMap;

import com.bitcamp.web.domain.CustomerDTO;
import com.bitcamp.web.mapper.CustomerMapper;
import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired CustomerService customerService;
    
    @Autowired CustomerDTO customer;
    @Autowired CustomerMapper mapper;

    @RequestMapping("/count")
    public String index() {
        System.out.println("customer url 경로로 들어옴 ");
        int count = customerService.countAll();
        System.out.println("고객의 총인원"+ count);
        return count + "";
        
    }

    @GetMapping("/{customerId}/{password}")
    public  CustomerDTO login(@PathVariable("customerId")String id, @PathVariable("password")String pass) {
        //System.out.println(""+ param.getPassword());
       // System.out.println("ajax로 넘어온 id:" + id);
      //  System.out.println("ajax로 넘어온 pass:" + pass);
        customer.setCustomerId(id);
        customer.setPassword(pass);
        //CustomerDTO member = customerService.login(customer);
        //System.out.println("db에서 넘어온 이름:" + member.getCustomerName()); 
        //return (!customerService.login(customer).getCustomerName().equals(""))? "SUCCESS":"FAIL";
        //return (customerService.login(customer)!= null)?"SUCCESS":"FAIL";
        return customerService.login(customer);

    }
    
    @PostMapping("")
    public HashMap<String,Object> join(@RequestBody CustomerDTO param){
        System.out.println(param.getCustomerId());
        System.out.println(param.getPassword());
        System.out.println(param.getCustomerName());
        customerService.addCustomer(param);
        HashMap<String,Object> map = new HashMap<>();
        map.put("result", "SUCCESS");
        return map;
    }
    
}