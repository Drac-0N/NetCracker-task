package com.cracker.manual.repository;

import com.cracker.manual.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(long id);
}
