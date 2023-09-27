package dev.concat.vab.ecommerce.services;

import dev.concat.vab.ecommerce.entities.EcomRoleEntity;

import java.util.Optional;

public interface IEcomRoleService {
    EcomRoleEntity createEcomRole(EcomRoleEntity role);
    Optional<EcomRoleEntity> findByName(String name);

}
