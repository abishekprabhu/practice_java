package com.hcltech.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_seq")
    @SequenceGenerator(name = "exam_seq", sequenceName = "exam_seq", allocationSize = 1)
    private Long id;

    private String name;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @OneToMany(mappedBy = "exam" , cascade = CascadeType.ALL)
    private List<Marks> marks;

}
