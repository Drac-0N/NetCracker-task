package com.cracker.manual.controller;

import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Group;
import com.cracker.manual.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineRepository repository;

    @GetMapping
    public List<Discipline> getDisciplines() {
        return repository.findAll();
    }

    //@GetMapping(path = "/{id}")
    //public List<Discipline> getDisciplinesByGroupId(@PathVariable long id) {
    //    return repository.getDisciplinesByGroupId(id);
    //}

    //@GetMapping(path = "/{id}")
    //public List<Discipline> getDiscipline(@PathVariable Long id) {
    //    return repository.findAllGroupsByDisciplineId(id);
    //}
}
