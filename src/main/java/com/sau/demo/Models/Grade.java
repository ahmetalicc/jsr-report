package com.sau.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fin")
    private Float fin;

    @Column(name = "homework")
    private Float homework;

    @Column(name = "midterm")
    private Float midterm;

    @Column(name = "project")
    private Float project;

    @Column(name = "quiz")
    private Float quiz;


}
