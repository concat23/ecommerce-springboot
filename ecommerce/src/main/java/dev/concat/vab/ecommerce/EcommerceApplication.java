package dev.concat.vab.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;


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