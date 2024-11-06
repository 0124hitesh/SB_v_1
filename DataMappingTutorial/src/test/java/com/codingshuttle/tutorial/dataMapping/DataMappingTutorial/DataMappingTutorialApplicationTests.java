package com.codingshuttle.tutorial.dataMapping.DataMappingTutorial;

import com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.clients.EmployeeClient;
import com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class DataMappingTutorialApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllEmployeesTest() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	void createNewEmployeeTest() {
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "shiv", "shiv@gmail.com", 23,
				"USER", 5000.0, LocalDate.of(2020, 12, 1), true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}
