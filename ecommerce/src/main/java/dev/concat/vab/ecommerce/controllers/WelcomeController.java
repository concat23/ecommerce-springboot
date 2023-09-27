package dev.concat.vab.ecommerce.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({"http://localhost:6868","http://localhost:8099"})
@RestController
@RequestMapping(path = "/api")
public class WelcomeController{

    @GetMapping("/")
    public String welcome(){
        return "Welcome to my application";
    }

}