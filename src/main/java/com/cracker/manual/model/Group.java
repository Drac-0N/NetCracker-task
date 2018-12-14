package com.cracker.manual.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long groupId;
    private String name;
    private String faculty;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "discipline_group",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "discipline_id")}
    )
    @JsonIgnoreProperties("groups")
    private List<Discipline> disciplines;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;

}
