package dev.concat.vab.ecommerce.repositories;

import dev.concat.vab.ecommerce.domain.EcomRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEcomRoleRepository extends JpaRepository<EcomRole,Long> {
    EcomRole findByName(String name);
}
