package dev.concat.vab.ecommerce.repositories;

import dev.concat.vab.ecommerce.entities.EcomUserEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEcomUserRepository extends JpaRepository<EcomUserEntity,String> {
    Optional<EcomUserEntity> findByUsernameOrEmail(String username, String email);
    Optional<EcomUserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<EcomUserEntity> findByEmail(String email);
}
