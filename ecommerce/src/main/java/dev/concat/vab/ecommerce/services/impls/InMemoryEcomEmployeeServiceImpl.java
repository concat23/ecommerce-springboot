package dev.concat.vab.ecommerce.services.impls;

import dev.concat.vab.ecommerce.domain.EcomEmployee;
import dev.concat.vab.ecommerce.repositories.InMemoryEcomEmployeeRepository;
import dev.concat.vab.ecommerce.services.IEcomEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemory")
public class InMemoryEcomEmployeeServiceImpl implements IEcomEmployeeService {

    private final InMemoryEcomEmployeeRepository inMemoryEcomEmployeeRepository;


    @Override
    public EcomEmployee add(EcomEmployee employee) {
        EcomEmployee createdEmpl = inMemoryEcomEmployeeRepository.add(employee);
        return createdEmpl;
    }

    @Override
    public List<EcomEmployee> getAllEmployees() {
        return inMemoryEcomEmployeeRepository.getAllEmployees();
    }

    @Override
    public EcomEmployee findById(Integer id) {
        return inMemoryEcomEmployeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(EcomEmployee employee) {

    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryEcomEmployeeRepository.deleteById(id);
    }
}
