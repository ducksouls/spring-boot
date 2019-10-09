package cn.lai.myspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Controller + ResponseBody
@RequestMapping("test")
public class HelloWorldController {

    @GetMapping("hello")
    public String sayHello(){
        return "hello world";
    }
}
