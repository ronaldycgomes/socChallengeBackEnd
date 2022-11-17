package com.challengeBackend.socbackend.controller;
import com.challengeBackend.socbackend.exception.EmployeeNotFoundException;
import com.challengeBackend.socbackend.exception.ExamNotFoundException;
import com.challengeBackend.socbackend.model.Employee;
import com.challengeBackend.socbackend.model.Exam;
import com.challengeBackend.socbackend.repository.EmployeeRepository;
import com.challengeBackend.socbackend.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    Employee newEmployee (@Valid @RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/allemployees")
    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));

    }

    @PutMapping("/employee/{id}")
    Employee updateEmployee(@Valid @RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setEmployee_name(newEmployee.getEmployee_name());
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "Funcionário com ID " + id + " foi deletado com sucesso";
    }
}
