package com.cracker.manual.repository;

import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Student;
import com.cracker.manual.model.StudentDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDisciplineRepository extends JpaRepository<StudentDiscipline, Long> {
    List<StudentDiscipline> findAllByStudentAndDiscipline(Student student, Discipline discipline);
}
