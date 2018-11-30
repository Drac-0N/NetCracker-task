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

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }
}
