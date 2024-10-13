package com.springBootWeb.springBootWeb.controllers;

import com.springBootWeb.springBootWeb.dto.EmployeeDTO;
import com.springBootWeb.springBootWeb.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Long employeeID) {
//        return new EmployeeDTO(employeeID, "name", "emaill", 102, LocalDate.of(2024, 9, 11), true);

        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeByID(employeeID);
        return employeeDTO.
                map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).
                orElse(ResponseEntity.notFound().build());
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


    //    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        return employeeService.createEmployee(inputEmployee);
//    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //    @PutMapping(path = "/{employeeId}")
//    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
//        return employeeService.updateEmployeeById(employeeId, employeeDTO);
//    }
    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId) {
        return employeeService.updatePartialEmployeeById(employeeId, updates);
    }
}
