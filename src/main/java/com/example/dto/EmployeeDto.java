package com.example.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeDto{
        private String id;
        private String fullName;
        private String salary;


//    @Builder(toBuilder = true)
//    public EmployeeDto{
//
//    }
}
