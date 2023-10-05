package dev.concat.vab.ecommerce.services.impls;

import dev.concat.vab.ecommerce.entities.EcomRoleEntity;
import dev.concat.vab.ecommerce.repositories.IEcomRoleEntityRepository;
import dev.concat.vab.ecommerce.services.IEcomRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcomRoleServiceImpl implements IEcomRoleService {

    @Autowired
    private IEcomRoleEntityRepository iEcomRoleEntityRepository;

    @Override
    public EcomRoleEntity createEcomRole(EcomRoleEntity role) {
        EcomRoleEntity createdRole = this.iEcomRoleEntityRepository.save(role);
        return createdRole;
    }

    @Override
    public Optional<EcomRoleEntity> findByName(String name) {
        return iEcomRoleEntityRepository.findByName(name);
    }


}
