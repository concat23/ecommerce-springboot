package dev.concat.vab.ecommerce.repositories;

import java.util.Optional;

import dev.concat.vab.ecommerce.entities.EcomRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEcomRoleEntityRepository extends JpaRepository<EcomRoleEntity,String>{
    Optional<EcomRoleEntity> findByName(String name);


}
