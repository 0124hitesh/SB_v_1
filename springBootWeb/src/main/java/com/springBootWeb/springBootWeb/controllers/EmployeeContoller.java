package com.springBootWeb.springBootWeb.controllers;

import com.springBootWeb.springBootWeb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

//    @GetMapping(path = "/getMyMessage")
//    public String getMessage() {
//        return "Message";
//    }

    @GetMapping("/{employeeID}")
//    public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeID") Long id) {
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeID) {
        return new EmployeeDTO(employeeID, "name", "emaill", 102, LocalDate.of(2024, 9, 11), true);
    }

    //    employees?age=5&name="HIT"
    @GetMapping
    public String getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name) {
        return "HLO " + name + " " + age;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(5L);
        return inputEmployee;
    }
}
