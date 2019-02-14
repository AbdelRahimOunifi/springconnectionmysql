package com.insat.springconnectionmysql.demo.Controller;

import com.insat.springconnectionmysql.demo.Repository.employeeRepository;
import com.insat.springconnectionmysql.demo.exceptionhandler.EmployeeNotFoundException;
import com.insat.springconnectionmysql.demo.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeeController {

    private employeeRepository repository;

    @Autowired
    public employeeController(employeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"", "/"})
    public List<employee> getAll() {
        return repository.findAll();
    }

    @PostMapping("/employee")
    public employee newemployee(@RequestAttribute employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employees/{id}")
    employee one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    employee replaceemployee(@RequestBody employee newemployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(newemployee.getFirstName());
                    employee.setLastName(newemployee.getLastName());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newemployee.setId(id);
                    return repository.save(newemployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteemployee(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
