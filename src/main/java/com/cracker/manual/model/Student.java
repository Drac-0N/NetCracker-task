package com.cracker.manual.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String[] name;
    private Group group;
    private String[] data;
    private ArrayList<Student> students;
}
