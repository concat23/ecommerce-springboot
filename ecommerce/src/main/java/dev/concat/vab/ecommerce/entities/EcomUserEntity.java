package dev.concat.vab.ecommerce.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter @Setter
@Entity
@Table(name = "enti_ecom_users",uniqueConstraints = { @UniqueConstraint(columnNames = {"username"}), @UniqueConstraint(columnNames = {"email"})})
public class EcomUserEntity extends BasicEntity{

    @Id
    @Column
    @Override
    public String getId() {
        return super.getId();
    }

    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private boolean isActive;

    @Column
    @Override
    public Integer getVersion() {
        return super.getVersion();
    }

    @Column
    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Column
    @Override
    public LocalDateTime getUpdatedAt() {
        return super.getUpdatedAt();
    }

    @Column
    @Override
    public String getUpdatedBy() {
        return super.getUpdatedBy();
    }

    @Column
    @Override
    public String getCreatedBy() {
        return super.getCreatedBy();
    }

    @Column
    private boolean enabled;
    @Column
    private boolean tokenExpired;

    @Column
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "enti_ecom_users_roles", joinColumns = @JoinColumn(name="enti_ecom_user_id", referencedColumnName = "id",nullable=false, updatable=false),
               inverseJoinColumns = @JoinColumn(name="enti_ecom_role_id",referencedColumnName = "id",nullable=false, updatable=false))
    private Set<EcomRoleEntity> roles = new HashSet<>();

    public void addRole(EcomRoleEntity role) {
        this.roles.add(role);
    }

    // @Access(javax.persistence.AccessType.PROPERTY)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "enti_ecom_users_roles", joinColumns = @JoinColumn(name="enti_ecom_user_id", referencedColumnName = "id",nullable=false, updatable=false),
               inverseJoinColumns = @JoinColumn(name="enti_ecom_role_id",referencedColumnName = "id",nullable=false, updatable=false))
    public Set<EcomRoleEntity> getRoles(){
        return roles;
    }
    
}
