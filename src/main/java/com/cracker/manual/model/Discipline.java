package com.cracker.manual.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long disciplineId;
    private String name;


    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Discipline_Group",
            joinColumns = { @JoinColumn(name = "discipline_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    @JsonIgnoreProperties("disciplines")
    private List<Group> groups;
}
