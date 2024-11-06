package com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.clients;

import com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
