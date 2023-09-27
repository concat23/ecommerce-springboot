package dev.concat.vab.ecommerce.controllers.api;

import dev.concat.vab.ecommerce.entities.EcomUserEntity;
import dev.concat.vab.ecommerce.responses.GenerateResponse;
import dev.concat.vab.ecommerce.services.IEcomUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@CrossOrigin("http://localhost:8099")
@RestController
@RequestMapping(path = "/api/users")
public class EcomUserController {

    @Autowired
    public IEcomUserService iEcomUserService;

    @PostMapping(path = "/create")
    public GenerateResponse<EcomUserEntity> create(@RequestBody EcomUserEntity user){
        try {
            EcomUserEntity newUser = this.iEcomUserService.createEcomUser(user);
            return new GenerateResponse<>(false, "User cannot be null", newUser);
        }catch (Exception exc){
            return null;
        }
    }

    @GetMapping(path = "/")
    public GenerateResponse<List<EcomUserEntity>> list(List<EcomUserEntity> list){
        try {
            List<EcomUserEntity> newUsers = this.iEcomUserService.findAllEcomUser(list);
            return new GenerateResponse<>(false, "Users cannot be null", newUsers);
        }catch (Exception exc){
            return null;
        }
    }

    @GetMapping("/hello")
    public String say(){
        return "Hello";
    }
}
