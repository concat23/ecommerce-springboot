package dev.concat.vab.ecommerce.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter @Setter
@Entity
@Table(name = "enti_ecom_roles")
public class EcomRoleEntity extends BasicEntity{
        
        @Id
        @Override
        public String getId(){
            return this.getId();
        }
        @Column
        private String name;
    
        @Column
        @ManyToMany(targetEntity=EcomUserEntity.class,mappedBy = "roles",cascade = CascadeType.ALL)
        private Set<EcomUserEntity> users = new HashSet<>();

        // @Access(javax.persistence.AccessType.PROPERTY)
        @ManyToMany(targetEntity=EcomUserEntity.class,mappedBy = "roles",cascade = CascadeType.ALL)
        public Set<EcomUserEntity> getUsers(){
            return users;
        }
    
        @Override
        public String toString() {
            return this.name;
        }
        
}
