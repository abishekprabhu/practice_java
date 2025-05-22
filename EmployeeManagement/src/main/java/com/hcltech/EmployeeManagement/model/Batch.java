package com.hcltech.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_seq")
    @SequenceGenerator(name = "batch_seq", sequenceName = "batch_seq", allocationSize = 1)
    private Long id;

    private String BatchCode;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    private List<Employee> employees;
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    private List<Exam> exams;

}
