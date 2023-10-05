package dev.concat.vab.ecommerce.repositories;

import dev.concat.vab.ecommerce.domain.EcomAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEcomAccountRepository extends JpaRepository<EcomAccount,Long> {
    EcomAccount findByUsername(String username);
}
