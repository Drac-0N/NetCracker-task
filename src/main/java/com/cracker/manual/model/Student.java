package com.cracker.manual.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    private Group group;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Discipline_Student",
            joinColumns = { @JoinColumn(name = "id_student") },
            inverseJoinColumns = { @JoinColumn(name = "id_discipline") }
    )
    private Set<Discipline> disciplines;

}
