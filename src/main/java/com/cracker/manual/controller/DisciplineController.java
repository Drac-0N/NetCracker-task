package com.cracker.manual.controller;

import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Group;
import com.cracker.manual.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @GetMapping
    public List<Discipline> getDisciplines() {
        return disciplineRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Group> createDiscipline(@RequestBody Discipline discipline) {
        Discipline newDiscipline = disciplineRepository.save(discipline);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{disciplineId}")
                .buildAndExpand(newDiscipline.getDisciplineId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
