package dev.concat.vab.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.concat.vab.ecommerce.entities.EcomRoleEntity;

@Repository
public interface IEcomRoleRepository extends JpaRepository<EcomRoleEntity,String>{
    Optional<EcomRoleEntity> findByName(String name);


}
