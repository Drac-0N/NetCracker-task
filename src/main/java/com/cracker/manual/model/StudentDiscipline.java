package com.cracker.manual.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "student_discipline")
public class StudentDiscipline {

    @Id
    long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    private Date date;
    private int mark;
}
