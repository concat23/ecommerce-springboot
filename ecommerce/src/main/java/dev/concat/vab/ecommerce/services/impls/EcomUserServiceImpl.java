package dev.concat.vab.ecommerce.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.concat.vab.ecommerce.entities.EcomUserEntity;
import dev.concat.vab.ecommerce.exceptions.ResourceNotFoundException;
import dev.concat.vab.ecommerce.repositories.IEcomUserRepository;
import dev.concat.vab.ecommerce.services.IEcomUserService;

@Service
public class EcomUserServiceImpl implements IEcomUserService{

    @Autowired
    private IEcomUserRepository iEcomUserRepository;

    @Override
    public EcomUserEntity createEcomUser(EcomUserEntity user){
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
         
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }
        EcomUserEntity createdUser = this.iEcomUserRepository.save(user);

        return createdUser;
    }

    @Override
    public List<EcomUserEntity> findAllEcomUser(List<EcomUserEntity> users){
        try{
            if(users == null){
                users = new ArrayList<>();
            }
            List<EcomUserEntity> foundedList = this.findAllEcomUser(users);
            return foundedList;
        }catch(ResourceNotFoundException rnfe){
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<EcomUserEntity>findByUsernameOrEmail(String username,String email){
        return this.findByUsernameOrEmail(username, email);
    }

    @Override
    public Optional<EcomUserEntity> findByUsername(String username) {
        return this.iEcomUserRepository.findByUsername(username);
    }

    @Override
    public boolean isUsernameTaken(String username){
        return iEcomUserRepository.existsByUsername(username);
    }

    @Override
    public Optional<EcomUserEntity> findByEmail(String email){
        return this.iEcomUserRepository.findByEmail(email);
    }

    @Override
    public boolean isEmailTaken(String email){
        return iEcomUserRepository.existsByEmail(email);
    }

}

