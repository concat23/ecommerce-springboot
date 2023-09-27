package dev.concat.vab.ecommerce.controllers.ecom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping(path = "/")
    public String home(){return "<h1>Home Page</h1>";}
    @GetMapping(path ="/user" )
    public String user(){return "<h1>User Auth</h1>";}
    @GetMapping(path = "/admin")
    public String admin(){ return "<h1>Admin Auth</h1>";}
}
