package model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

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
