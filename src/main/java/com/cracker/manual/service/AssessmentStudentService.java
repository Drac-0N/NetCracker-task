package com.cracker.manual.service;

import com.cracker.manual.dto.AssesmentDTO;
import com.cracker.manual.entity.AssesmentRequest;
import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Student;
import com.cracker.manual.model.StudentDiscipline;
import com.cracker.manual.repository.DisciplineRepository;
import com.cracker.manual.repository.StudentDisciplineRepository;
import com.cracker.manual.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AssessmentStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private StudentDisciplineRepository studentDisciplineRepository;

    public StudentDiscipline addAssesment(Long studentId, Long disciplineId, AssesmentRequest assesment) {
        StudentDiscipline studentDiscipline = null;
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            Optional<Discipline> discipline = disciplineRepository.findById(disciplineId);
            if (discipline.isPresent()) {
                studentDiscipline = new StudentDiscipline();
                studentDiscipline.setStudent(student.get());
                studentDiscipline.setDiscipline(discipline.get());
                studentDiscipline.setDate(LocalDate.now());
                studentDiscipline.setMark(assesment.getMark());
                studentDiscipline = studentDisciplineRepository.save(studentDiscipline);
            }
        }
        return studentDiscipline;
    }

    public List<AssesmentDTO> getAssesment(Long studentId, Long disciplineId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            Optional<Discipline> discipline = disciplineRepository.findById(disciplineId);
            if (discipline.isPresent()) {
                return studentDisciplineRepository.findAllByStudentAndDiscipline(student.get(), discipline.get())
                        .stream()
                        .map(assesment -> new AssesmentDTO(assesment.getMark(), assesment.getDate()))
                        .collect(Collectors.toList());
            }
        }
        return null;
    }
}