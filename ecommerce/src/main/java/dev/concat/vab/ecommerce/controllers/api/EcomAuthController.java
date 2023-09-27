//package dev.concat.vab.ecommerce.controllers.api;
//import dev.concat.vab.ecommerce.dtos.LoginDto;
//import dev.concat.vab.ecommerce.dtos.RegisterDto;
//import dev.concat.vab.ecommerce.entities.EcomRoleEntity;
//import dev.concat.vab.ecommerce.entities.EcomUserEntity;
//import dev.concat.vab.ecommerce.services.IEcomRoleService;
//import dev.concat.vab.ecommerce.services.IEcomUserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import java.util.Collections;
//
//@Slf4j
//@Validated
//@CrossOrigin("http://localhost:8099")
//@RestController
//@RequestMapping("/api/auth")
//public class EcomAuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    @Autowired
//    private IEcomUserService iEcomUserService;
//
//    @Autowired
//    private IEcomRoleService iEcomRoleService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public EcomAuthController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto){
//
//        // add check for username exists in a DB
//        if(iEcomUserService.isUsernameTaken(registerDto.getUsername())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }
//
//        // add check for email exists in DB
//        if(iEcomUserService.isEmailTaken(registerDto.getEmail())){
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
//        }
//
//        // create user object
//        EcomUserEntity user = new EcomUserEntity();
//        user.setName(registerDto.getName());
//        user.setUsername(registerDto.getUsername());
//        user.setEmail(registerDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//        EcomRoleEntity roles = this.iEcomRoleService.findByName("ADMIN").get();
//        user.setRoles(Collections.singleton(roles));
//
//        this.iEcomUserService.createEcomUser(user);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//
//    }
//
//}