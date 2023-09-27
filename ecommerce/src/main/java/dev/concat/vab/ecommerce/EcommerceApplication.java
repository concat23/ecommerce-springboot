package dev.concat.vab.ecommerce;

import dev.concat.vab.ecommerce.repositories.IEcomUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


//@SpringBootApplication(scanBasePackages = "dev.concat.vab.ecommerce",exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = "dev.concat.vab.ecommerce")
//@EnableJpaRepositories(basePackageClasses = IEcomUserRepository.class)
public class EcommerceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(EcommerceApplication.class);
    }

    public static void main(String[]args){
           SpringApplication.run(EcommerceApplication.class, args);
    }
}