package dev.concat.vab.ecommerce.repositories;

import dev.concat.vab.ecommerce.domain.EcomEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaEcomEmployeeRepository extends JpaRepository<EcomEmployee,Integer> {
    // Define more if need be
}
