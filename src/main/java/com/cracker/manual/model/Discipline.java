package com.cracker.manual.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID_Discipline;
    private String name;


}
