package com.cracker.manual.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "group_discipline")
public class GroupDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    private String professor;

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
