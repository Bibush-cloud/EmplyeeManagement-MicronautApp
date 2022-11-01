package com.example.mapper;

import com.example.dto.EmployeeDto;
import com.example.entity.EmployeeEntity;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder(toBuilder = true)
public class EmployeeMapper {
    //changing into Entity type
    public static EmployeeEntity toEnity (EmployeeDto employeeDto){
        return EmployeeEntity.builder()
                .id(Optional.ofNullable(employeeDto.getId()).orElse(UUID.randomUUID().toString()))
                .fullName(employeeDto.getFullName())
                .salary(employeeDto.getSalary())
                .build();
    }

    //changing into Dto Type
    public static EmployeeDto toDto (EmployeeEntity employeeEntity){
        return EmployeeDto.builder()
                .id(employeeEntity.getId())
                .fullName(employeeEntity.getFullName())
                .salary(employeeEntity.getSalary())
                .build();
    }

    public static List<EmployeeDto> getEmployeeDtoList (List<EmployeeEntity> employeeEntityList){
        return employeeEntityList.stream().map(data->toDto(data)).collect(Collectors.toList());
    }



}
