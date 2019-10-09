package cn.lai.myspringboot.controller;

import cn.lai.myspringboot.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    //controller返回视图
    @GetMapping("/sayhello")
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    //controller + responsebody接受一个json，装配成对象，然后返回客户端
    @PostMapping("/person")
    @ResponseBody
    public Person personHello(@RequestBody Person person){
        System.out.println(person.getAge());
        person.setAge(100);
        return person;
    }
}
