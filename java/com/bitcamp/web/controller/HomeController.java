package com.bitcamp.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller//클래스를 빈으로 등록  -  클래스만 빈으로 등록 가능  
public class  HomeController{
     
    @RequestMapping("/") // 빈아님
    public String name() {
          System.out.println("루트 URL경로로 들어옴 ");
          return "index";
     }

}