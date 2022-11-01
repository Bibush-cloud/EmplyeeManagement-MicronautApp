package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.service.EmployeeService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller
public class EmployeeController {

    @Inject
    EmployeeService employeeService;

    @Post("/addEmployee")
    public EmployeeDto addEmployees(@Body EmployeeDto body){
        return employeeService.addEmployee(body);
    }

    @Get("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable String id){
        return employeeService.findByEmployeeId(id);
    }

    @Get("/employees")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.allEmployees();
    }

    @Delete("/{id}")
    public void deleteEmployeeById(@PathVariable String id){
        employeeService.deleteById(id);
        System.out.println("Deleted");
    }
}
