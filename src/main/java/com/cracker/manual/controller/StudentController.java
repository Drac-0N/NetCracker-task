package com.cracker.manual.controller;

import com.cracker.manual.dto.GroupDTO;
import com.cracker.manual.model.Student;
import com.cracker.manual.repository.StudentDisciplineRepository;
import com.cracker.manual.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/students")

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDisciplineRepository studentDisciplineRepository;

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student createdStudent = studentRepository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentId}").buildAndExpand(createdStudent.getStudentId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable long studentId) {

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) return ResponseEntity.notFound().build();

        student.setStudentId(studentId);
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable long studentId) {
        studentRepository.deleteById(studentId);
    }

    @GetMapping(path = "/{studentId}/group")
    public GroupDTO getDiscipline(@PathVariable Long studentId) {
        Optional<Student> student = studentRepository.findAllByStudentId(studentId);
        GroupDTO group = null;
        if (student.isPresent()) {
            group = new GroupDTO(student.get().getGroup().getGroupId(),
                    student.get().getGroup().getName());
        }
        return group;
    }
}
