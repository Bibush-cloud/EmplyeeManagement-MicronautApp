package com.example.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String salary;
}
