package dev.concat.vab.ecommerce.controllers.admin;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/loginA")
public class EcomUserAdminRegistrationController {

    private UserDetailsService userDetailsService;

    public EcomUserAdminRegistrationController(UserDetailsService userDetailsService) {
        super();
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    public String registerUserAccount(){
        return "index";
    }

}
