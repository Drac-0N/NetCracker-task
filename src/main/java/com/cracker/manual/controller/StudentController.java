package com.cracker.manual.controller;

import com.cracker.manual.dto.DisciplineDTO;
import com.cracker.manual.dto.GroupDTO;
import com.cracker.manual.model.Group;
import com.cracker.manual.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cracker.manual.repository.StudentRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/students")

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Optional<Student> student = studentRepository.findById(id);
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
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}").buildAndExpand(createdStudent.getStudentId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        if (!studentOptional.isPresent()) return ResponseEntity.notFound().build();

        student.setStudentId(id);
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping(path = "/{id}/group")
    public Group getDiscipline(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findAllByStudentId(id);
        Group group = null;
        if (student.isPresent()) {
            group = student.get().getGroup();
        }
        return group;
    }
}
