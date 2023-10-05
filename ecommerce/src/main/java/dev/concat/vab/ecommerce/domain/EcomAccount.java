package dev.concat.vab.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dom_ecom_accounts")
public class EcomAccount {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    @NotNull
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;
    private String email;
    private Boolean isActive;
    private boolean enabled = true;
    private boolean credentialsexpired = false;
    private boolean expired = false;
    private boolean locked = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dom_ecom_account_role",
            joinColumns = @JoinColumn(name = "dom_ecom_accountId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dom_ecom_roleId",referencedColumnName = "id")
    )
    private Set<EcomRole> roles;

}
