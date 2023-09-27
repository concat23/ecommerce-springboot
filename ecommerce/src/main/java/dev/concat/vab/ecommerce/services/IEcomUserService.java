package dev.concat.vab.ecommerce.services;

import java.util.List;
import java.util.Optional;

import dev.concat.vab.ecommerce.entities.EcomUserEntity;

public interface IEcomUserService{ 

      EcomUserEntity createEcomUser(EcomUserEntity user);
     
      List<EcomUserEntity> findAllEcomUser(List<EcomUserEntity> users);

      Optional<EcomUserEntity>findByUsernameOrEmail(String username,String email);

      boolean isUsernameTaken(String username);
      
      boolean isEmailTaken(String email);

      Optional<EcomUserEntity> findByEmail(String email);

      Optional<EcomUserEntity> findByUsername(String username);

}