package dev.concat.vab.ecommerce.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.concat.vab.ecommerce.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.concat.vab.ecommerce.entities.EcomUserEntity;
import dev.concat.vab.ecommerce.repositories.IEcomUserEntityRepository;
import dev.concat.vab.ecommerce.services.IEcomUserService;

@Service
public class EcomUserServiceImpl implements IEcomUserService{

    @Autowired
    private IEcomUserEntityRepository iEcomUserEntityRepository;

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
        EcomUserEntity createdUser = this.iEcomUserEntityRepository.save(user);

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
        return this.iEcomUserEntityRepository.findByUsername(username);
    }

    @Override
    public boolean isUsernameTaken(String username){
        return iEcomUserEntityRepository.existsByUsername(username);
    }

    @Override
    public Optional<EcomUserEntity> findByEmail(String email){
        return this.iEcomUserEntityRepository.findByEmail(email);
    }

    @Override
    public boolean isEmailTaken(String email){
        return iEcomUserEntityRepository.existsByEmail(email);
    }

}

