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
import java.util.Optional;

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

    @GetMapping(path = "/{disciplineId}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable long disciplineId) {
        Optional<Discipline> discipline = disciplineRepository.findById(disciplineId);
        if (discipline.isPresent()) {
            return ResponseEntity.ok(discipline.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{disciplineId}")
    public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline discipline, @PathVariable long disciplineId) {

        Optional<Discipline> disciplineOptional = disciplineRepository.findById(disciplineId);
        if (!disciplineOptional.isPresent())
            return ResponseEntity.notFound().build();

        discipline.setDisciplineId(disciplineId);
        Discipline updatedDiscipline = disciplineRepository.save(discipline);
        return ResponseEntity.ok(updatedDiscipline);
    }

    @DeleteMapping(path = "/{disciplineId}")
    public void deleteDiscipline(@PathVariable long disciplineId) {
        disciplineRepository.deleteById(disciplineId);
    }

//    @GetMapping(path = "/{disciplineId}/groups")
//    public List<GroupDTO> getGroups(@PathVariable Long disciplineId) {
//        Optional<Discipline> discipline = disciplineRepository.findAllByDisciplineId(disciplineId);
//        List<GroupDTO> groups = new ArrayList<>();
//        if (discipline.isPresent()) {
//            groups = discipline.get()
//                    .getGroups().stream()
//                    .map(group -> new GroupDTO(group.getName()))
//                    .collect(Collectors.toList());
//        }
//        return groups;
//    }
}
