package model;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String faculty;
    private ArrayList<Student> students;
}
