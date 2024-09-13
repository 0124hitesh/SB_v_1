package com.springBootWeb.springBootWeb.controllers;

import com.springBootWeb.springBootWeb.dto.EmployeeDTO;
import com.springBootWeb.springBootWeb.entities.EmployeeEntity;
import com.springBootWeb.springBootWeb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

    private final EmployeeRepository employeeRepository;

    public EmployeeContoller(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
//    @GetMapping(path = "/getMyMessage")
//    public String getMessage() {
//        return "Message";
//    }

    @GetMapping("/{employeeID}")
//    public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeID") Long id) {
    public EmployeeEntity getEmployeeByID(@PathVariable Long employeeID) {
//        return new EmployeeDTO(employeeID, "name", "emaill", 102, LocalDate.of(2024, 9, 11), true);
        return employeeRepository.findById(employeeID).orElse(null);
    }

    //    employees?age=5&name="HIT"
    @GetMapping
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name) {
//        return "HLO " + name + " " + age;
        return employeeRepository.findAll();
    }

//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        inputEmployee.setId(5L);
//        return inputEmployee;
//    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }
}
