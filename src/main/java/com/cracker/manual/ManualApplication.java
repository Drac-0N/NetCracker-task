package com.cracker.manual;

import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Group;
import com.cracker.manual.model.Student;
import com.cracker.manual.repository.DisciplineRepository;
import com.cracker.manual.repository.GroupRepository;
import com.cracker.manual.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManualApplication implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManualApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Discipline discipline = new Discipline();
        discipline.setName("Math");
        disciplineRepository.save(discipline);

        Group group = new Group();
        group.setName("First Group");
        group.setFaculty("FAIT");
        groupRepository.save(group);

        Student student = new Student();
        student.setName("Иван");
        studentRepository.save(student);

    }
}
