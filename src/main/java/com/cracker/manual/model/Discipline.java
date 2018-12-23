package com.cracker.manual.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "disciplines")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long disciplineId;
    private String name;
}
