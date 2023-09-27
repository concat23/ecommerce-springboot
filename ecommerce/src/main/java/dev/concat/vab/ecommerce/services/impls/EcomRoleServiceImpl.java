package dev.concat.vab.ecommerce.services.impls;

import dev.concat.vab.ecommerce.entities.EcomRoleEntity;
import dev.concat.vab.ecommerce.repositories.IEcomRoleRepository;
import dev.concat.vab.ecommerce.services.IEcomRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcomRoleServiceImpl implements IEcomRoleService {

    @Autowired
    private IEcomRoleRepository iEcomRoleRepository;

    @Override
    public EcomRoleEntity createEcomRole(EcomRoleEntity role) {
        EcomRoleEntity createdRole = this.iEcomRoleRepository.save(role);
        return createdRole;
    }

    @Override
    public Optional<EcomRoleEntity> findByName(String name) {
        return iEcomRoleRepository.findByName(name);
    }


}
