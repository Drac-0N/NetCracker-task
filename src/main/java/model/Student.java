package model;

import lombok.Data;
import repository.StudentRepository;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private String fathersName; //Не знаю как отчество по английски, честно говоря написать
    private Group group;
    private Date data;

}
