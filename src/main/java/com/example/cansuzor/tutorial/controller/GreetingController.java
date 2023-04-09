package com.example.cansuzor.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

    public class GreetingController {
    @RequestMapping(path= "/greeting", method = RequestMethod.GET)
    public String getGreeting(){
        return "Hi, this is Cansu Zor and I love kofte";
    }
}
