package com.cracker.manual.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID_Discipline;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Discipline_Group",
            joinColumns = { @JoinColumn(name = "id_discipline") },
            inverseJoinColumns = { @JoinColumn(name = "id_group") }
    )
    private Set<Group> groups;
}
