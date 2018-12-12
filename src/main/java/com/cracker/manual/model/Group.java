package com.cracker.manual.model;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String faculty;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Descipline_Group",
            joinColumns = { @JoinColumn(name = "id_group") },
            inverseJoinColumns = { @JoinColumn(name = "id_discipline") }
    )
    private Set<Descipline> subjects;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Student> students;
}
