package kr.ac.hansung.cse.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello(){
        return "index";
    }

    private void error() {
        HashMap<Integer,String> strings = new HashMap<>();
    }
    @GetMapping("/hi")
    public String sayHi(){
        return "index";
    }


}
