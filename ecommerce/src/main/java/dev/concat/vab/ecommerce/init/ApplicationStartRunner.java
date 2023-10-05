package dev.concat.vab.ecommerce.init;

import dev.concat.vab.ecommerce.domain.EcomRole;
import dev.concat.vab.ecommerce.repositories.IEcomRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {

    private final IEcomRoleRepository iEcomRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        EcomRole roleUser = new EcomRole(1L,"123","ROLE_USER");
        EcomRole roleAdmin = new EcomRole(2L,"456","ROLE_ADMIN");
        iEcomRoleRepository.saveAll(Arrays.asList(roleUser,roleAdmin));
    }
}
