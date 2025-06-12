package com.abhishek.hibernatemapping02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator = "GenerationType.IDENTITY")
    private Long id;
    private String name;
    private String industry;
    private String location;
    private LocalDate foundedDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employees>  employees;
}
