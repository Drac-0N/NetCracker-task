package com.cracker.manual.repository;

import com.cracker.manual.model.Group;
import com.cracker.manual.model.StudentDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDisciplineRepository extends JpaRepository<StudentDiscipline, Long> {
}
