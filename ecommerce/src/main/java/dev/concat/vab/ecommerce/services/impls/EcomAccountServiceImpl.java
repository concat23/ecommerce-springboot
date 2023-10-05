package dev.concat.vab.ecommerce.services.impls;

import dev.concat.vab.ecommerce.domain.EcomAccount;
import dev.concat.vab.ecommerce.repositories.IEcomRoleRepository;
import dev.concat.vab.ecommerce.services.IEcomAccountService;
import dev.concat.vab.ecommerce.domain.EcomRole;
import dev.concat.vab.ecommerce.repositories.IEcomAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EcomAccountServiceImpl implements IEcomAccountService {

    private final IEcomAccountRepository iEcomAccountRepository;
    private final IEcomRoleRepository iEcomRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public EcomAccount createAccount(EcomAccount account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        EcomRole role = iEcomRoleRepository.findByName("ROLE_USER");
        Set<EcomRole> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);

        return iEcomAccountRepository.save(account);
    }

    @Override
    public EcomAccount findByUsername(String username) {
        return iEcomAccountRepository.findByUsername(username);
    }

    @Override
    public List<EcomAccount> getAccounts() {
        return iEcomAccountRepository.findAll();
    }
}
