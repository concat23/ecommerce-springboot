package dev.concat.vab.ecommerce.repositories;

import dev.concat.vab.ecommerce.domain.EcomEmployee;
import dev.concat.vab.ecommerce.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public class InMemoryEcomEmployeeRepository {

    private static final List<EcomEmployee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new EcomEmployee(1,"John","Smith","john@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(2,"Tom","Ronald","tom@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(3,"Andy","Lucky","andy@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(4,"Cris","Future","cris@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(5,"Henry","Alone","henry@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(6,"Kan","Alex","kan@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(7,"Miz","Lucy","miz@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(8,"Nancy","Monster","nancy@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(9,"Thomas","Dany","thomas@gmail.com",null,null));
        DATABASE.add(new EcomEmployee(10,"Alice","Pretty","alice@gmail.com",null,null));
    }

    // Save an employee
    public EcomEmployee add(EcomEmployee employee) {
        DATABASE.add(employee);
        return employee;
    }


    // Get employee
    public List<EcomEmployee> getAllEmployees(){
        List<EcomEmployee> ecomEmployees = new ArrayList<>(DATABASE);
        return ecomEmployees;
    }

    //Get one employee
    public EcomEmployee findById(Integer id){
        Optional<EcomEmployee> employeeOptional = DATABASE
                .stream()
                .filter(empl -> id.equals(empl.getId()))
                .findFirst();

        // Check if the employee is present, otherwise throw an exception
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new ResourceNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee
    public void updateEmployee(EcomEmployee employee){

    }

    public Boolean deleteById(Integer id){
        Optional<EcomEmployee> employeeOptional = DATABASE
                .stream()
                .filter(empl -> id.equals(empl.getId()))
                .findFirst();

        if (employeeOptional.isPresent()) {
            EcomEmployee employee = employeeOptional.get();

            // Set the deletedAt field to the current date/time
            employee.setDeletedAt(new Date());

            return true; // Return true to indicate successful soft deletion.
        } else {
            return false; // Return false to indicate that the employee was not found.
        }
    }


}
