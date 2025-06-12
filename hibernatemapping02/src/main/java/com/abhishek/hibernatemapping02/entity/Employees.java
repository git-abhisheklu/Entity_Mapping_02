package com.abhishek.hibernatemapping02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(generator = "GenerationType.IDENTITY")
    private Long id;
    private String name;
    private String position;
    private String email;
    private Double salary;
    private LocalDate joiningDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
