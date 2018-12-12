package com.cracker.manual.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Descipline")
public class Descipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID_Discipline;
    private String name;


}
