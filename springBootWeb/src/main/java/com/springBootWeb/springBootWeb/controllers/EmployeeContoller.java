package com.springBootWeb.springBootWeb.controllers;

import com.springBootWeb.springBootWeb.dto.EmployeeDTO;
import com.springBootWeb.springBootWeb.entities.EmployeeEntity;
import com.springBootWeb.springBootWeb.repositories.EmployeeRepository;
import com.springBootWeb.springBootWeb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

    private final EmployeeService employeeService;

    public EmployeeContoller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    @GetMapping(path = "/getMyMessage")
//    public String getMessage() {
//        return "Message";
//    }

    @GetMapping("/{employeeID}")
//    public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeID") Long id) {
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeID) {
//        return new EmployeeDTO(employeeID, "name", "emaill", 102, LocalDate.of(2024, 9, 11), true);
        return employeeService.getEmployeeByID(employeeID);
    }

    //    employees?age=5&name="HIT"
    @GetMapping
    public List<EmployeeDTO> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name) {
//        return "HLO " + name + " " + age;
        return employeeService.getAllEmployee();
    }

//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        inputEmployee.setId(5L);
//        return inputEmployee;
//    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createEmployee(inputEmployee);
    }
}
