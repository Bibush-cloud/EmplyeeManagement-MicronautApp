package com.example.serviceImpl;

import com.example.dto.EmployeeDto;
import com.example.entity.EmployeeEntity;
import com.example.mapper.EmployeeMapper;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Inject;

import java.util.List;

@Primary
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        var data = EmployeeMapper.toEnity(employeeDto);
        var data2 = employeeRepository.save(data);
        return EmployeeMapper.toDto(data2);
    }

    @Override
    public EmployeeDto findByEmployeeId(String id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<EmployeeDto> allEmployees() {
        return EmployeeMapper.getEmployeeDtoList((List<EmployeeEntity>) employeeRepository.findAll());
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}
