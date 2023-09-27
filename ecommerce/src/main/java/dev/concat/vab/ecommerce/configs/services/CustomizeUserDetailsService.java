//package dev.concat.vab.ecommerce.configs.services;
//
//import dev.concat.vab.ecommerce.entities.EcomUserEntity;
//import dev.concat.vab.ecommerce.repositories.IEcomUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomizeUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    IEcomUserRepository iEcomUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<EcomUserEntity> user = iEcomUserRepository.findByUsername(username);
//        user.orElseThrow(() -> new  UsernameNotFoundException("Not found: "+ username));
//
//        return user.map(CustomUserDetails::new).get();
//    }
//}
