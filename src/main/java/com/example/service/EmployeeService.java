package com.example.service;

import com.example.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto findByEmployeeId(String id);

    List<EmployeeDto> allEmployees();

    public void deleteById(String id);

}
