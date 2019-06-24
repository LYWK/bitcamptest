package com.bitcamp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bitcamp.web.common.util.PageProxy;
import com.bitcamp.web.common.util.Printer;
import com.bitcamp.web.domain.CustomerDTO;
import com.bitcamp.web.mapper.CustomerMapper;
import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Autowired Printer p;
    @Autowired PageProxy pxy;

    

    @RequestMapping("/count")
    public String index() {
        System.out.println("customer url 경로로 들어옴 ");
        int count = customerService.countAll();
        p.accept("람다가 출력하 고객"+count);
        //System.out.println("고객의 총인원"+ count);
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
    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable String customerId){
     
         System.out.println("ID 검색 진입" +customerId);
        return customerService.findCustomerById(customerId);
    }
    
    @PostMapping("")
    public HashMap<String,Object> join(@RequestBody CustomerDTO param){
        // System.out.println(param.getCustomerId());
        // System.out.println(param.getPassword());
        // System.out.println(param.getCustomerName());
        customerService.addCustomer(param);
        HashMap<String,Object> map = new HashMap<>();
        map.put("result", "SUCCESS");
        return map;
    }

    @GetMapping("/page/{pageNum}")
    public HashMap<String, Object> list(@PathVariable String pageNum) {
        //List<CustomerDTO> list = new ArrayList<>();
        
        //rowCount , page_num, page_size, block_size 
        HashMap<String,Object> map = new HashMap<>();
        map.put("totalCount", customerService.countAll());
        map.put("page_num", pageNum);
        map.put("page_size", "5");
        map.put("block_size", "5");
        pxy.execute(map);
        
        map.put("list", customerService.findCustomer(pxy));
        map.put("pxy", pxy);
        // list = customerService.findCustomer(customer);
        //          for (CustomerDTO customer : list) { 
        //              System.out.println(customer.getCustomerId()+" : " 
        //                              +customer.getCustomerName()+" : " 
        //                              +customer.getPassword()+" : " 
        //                              +customer.getSsn()+" : " 
        //                              +customer.getPhone()+" : " 
        //                              +customer.getCity()+" : " 
        //                              +customer.getAddress()+" : " 
        //                              +customer.getPostalcode()); 
        //          } 
        
        return map;
    }




    @PutMapping("/{customerId}")
    public CustomerDTO  updateCustomer(@RequestBody CustomerDTO param){
        System.out.println("수정 할 객체 :" + param.toString());
        int res = customerService.updateCustomer(param);
        System.out.println("====>" + res);
        if (res == 1) {
            customer = customerService.findCustomerById(param.getCustomerId());
        } else {
            System.out.println("컨트롤러 수정 실패 ");
        }
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public HashMap<String,Object> deleteCustomer(@PathVariable("customerId")String id){
        HashMap<String,Object> map = new HashMap<>();
        customer.setCustomerId(id);
        customerService.deleteCustomer(customer);
        map.put("result", "SUCCESS");
        return map;
    }

    
}