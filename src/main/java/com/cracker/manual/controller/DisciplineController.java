package com.cracker.manual.controller;

import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Group;
import com.cracker.manual.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineRepository repository;

    @GetMapping
    public List<Discipline> getDisciplines() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Discipline> getDisciplineByGroupId(@PathVariable Long id) {
        Optional<Discipline> discipline = repository.findById(id);
        if (discipline.isPresent()) {
            return ResponseEntity.ok(discipline.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Discipline> getDisciplinesByGroupId(@PathVariable long id) {
        Optional<Discipline> disciplines = repository.getDisciplinesByGroupId(id);
        if (disciplines.isPresent()) {
            return ResponseEntity.ok(disciplines.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
