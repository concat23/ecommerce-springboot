package dev.concat.vab.ecommerce.resource;

import dev.concat.vab.ecommerce.domain.EcomEmployee;
import dev.concat.vab.ecommerce.services.IEcomEmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EcomEmployeeResource {

    private final IEcomEmployeeService iEcomEmployeeService;

    public EcomEmployeeResource( @Qualifier(value = "mySQLEcomEmployeeService") IEcomEmployeeService iEcomEmployeeService) {
        this.iEcomEmployeeService = iEcomEmployeeService;
    }

    @GetMapping
    public ResponseEntity<List<EcomEmployee>> getEmployees(){
        return ResponseEntity.ok(iEcomEmployeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<EcomEmployee> getEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(iEcomEmployeeService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<EcomEmployee> addEmployee(@RequestBody EcomEmployee employee){
        employee.setId(iEcomEmployeeService.getAllEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(iEcomEmployeeService.add(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(iEcomEmployeeService.deleteById(id));
    }


//    @PostMapping
//    public ResponseEntity<Boolean> updateEmployee(@PathVariable("id") Integer id){
//        return null;
//    }


    private URI getLocation(Integer id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }




}
