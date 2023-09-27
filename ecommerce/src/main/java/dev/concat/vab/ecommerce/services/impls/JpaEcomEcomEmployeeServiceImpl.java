package dev.concat.vab.ecommerce.services.impls;

import dev.concat.vab.ecommerce.domain.EcomEmployee;
import dev.concat.vab.ecommerce.repositories.IJpaEcomEmployeeRepository;
import dev.concat.vab.ecommerce.services.IEcomEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "mySQLEcomEmployeeService")
public class JpaEcomEcomEmployeeServiceImpl implements IEcomEmployeeService {

    private final IJpaEcomEmployeeRepository iJpaEcomEmployeeRepository;

    @Override
    public EcomEmployee add(EcomEmployee employee) {
        return iJpaEcomEmployeeRepository.save(employee);
    }

    @Override
    public List<EcomEmployee> getAllEmployees() {
        return iJpaEcomEmployeeRepository.findAll();
    }

    @Override
    public EcomEmployee findById(Integer id) {
        return iJpaEcomEmployeeRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(EcomEmployee employee) {

    }

    @Override
    public Boolean deleteById(Integer id) {
        iJpaEcomEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
