package com.wipro.repository;

import com.wipro.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

    public Employee findByName(String s);

    public void deleteByName(String name);


}
