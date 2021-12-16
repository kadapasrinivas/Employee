package com.wipro.controller;


import com.wipro.model.Employee;
import com.wipro.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/create")
    public void createEmpRecord(@RequestBody Employee employee){employeeRepo.save(employee);}

        @GetMapping("/getAll")
                public List<Employee> getAllRecordsFromDb(){return employeeRepo.findAll();}

    @GetMapping("/getByName/{name}")
    public Employee getByNameRecordsFromDb(@PathVariable String name) {

        return employeeRepo.findByName(name);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteByNameRecordsFromDb(@PathVariable String name){

         employeeRepo.deleteByName(name);


    }

    @PatchMapping("/delete/{name}/{sal}")
    public Employee updateByNameRecordsFromDb(@PathVariable String name,@PathVariable Double sal){

        Employee emp=employeeRepo.findByName(name);
        emp.setSal(sal);
        return employeeRepo.save(emp);

    }

@PutMapping("/update")
    public void updateEmpRecord(@RequestBody Employee employee){
        employeeRepo.save(employee);
    }


}
