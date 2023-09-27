//package dev.concat.vab.ecommerce.configs.services;
//
//import dev.concat.vab.ecommerce.entities.EcomUserEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class CustomUserDetails implements UserDetails {
//
//    private String username;
//    private String password;
//    private String email;
//    private boolean isActive;
//    private Set<SimpleGrantedAuthority> authorities;
//    public CustomUserDetails(EcomUserEntity user){
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.email = user.getEmail();
//        this.isActive = user.isActive();
//        this.authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isActive;
//    }
//}
