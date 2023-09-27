package dev.concat.vab.ecommerce.services;

import dev.concat.vab.ecommerce.domain.EcomEmployee;

import java.util.List;

public interface IEcomEmployeeService {
    // Save an employee
    EcomEmployee add(EcomEmployee employee);

    // Get employee
    List<EcomEmployee> getAllEmployees();

    //Get one employee
    EcomEmployee findById(Integer id);

    // Update employee
    void updateEmployee(EcomEmployee employee);

    Boolean deleteById(Integer id);

}