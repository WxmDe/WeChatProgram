package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Decription TODO
 * @Author wxm
 * @Date 2019/2/27 9:25
 **/
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "/data.json";
    }


}
