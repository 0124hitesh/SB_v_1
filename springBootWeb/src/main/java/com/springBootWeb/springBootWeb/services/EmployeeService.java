package com.springBootWeb.springBootWeb.services;

import com.springBootWeb.springBootWeb.dto.EmployeeDTO;
import com.springBootWeb.springBootWeb.entities.EmployeeEntity;
import com.springBootWeb.springBootWeb.exceptions.ResourceNotFoundException;
import com.springBootWeb.springBootWeb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeByID(Long employeeID) {
//        ModelMapper modelMapper = new ModelMapper();

        Optional<EmployeeEntity> employeeEntity  = employeeRepository.findById(employeeID);
        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployee() {
//        return employeeRepository.findAll();
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity employeeEntity =  employeeRepository.save(toSaveEntity);

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        isExitsByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public void isExitsByEmployeeId(Long employeeId) {
        boolean exist = employeeRepository.existsById((employeeId));
        if (!exist) {
            throw new ResourceNotFoundException("No employee exists with this id: " + employeeId);
        }
    }

    public boolean deleteEmployeeById(Long employeeId) {
        isExitsByEmployeeId(employeeId);

        employeeRepository.deleteById((employeeId));
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        isExitsByEmployeeId(employeeId);


        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((key, value) -> {
            Field fieldToBeUpdate = ReflectionUtils.findField(EmployeeEntity.class, key);
            fieldToBeUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdate, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
