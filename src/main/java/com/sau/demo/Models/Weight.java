package com.sau.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "weight")

public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;


    @Column(name = "fin_weight")
    private String fin_weight;

    @Column(name = "homework_weight")
    private String homework_weight;

    @Column(name = "project_weight")
    private String project_weight;

    @Column(name = "quiz_weight")
    private String quiz_weight;

    @Column(name = "midterm_weight")
    private String midterm_weight;

}
