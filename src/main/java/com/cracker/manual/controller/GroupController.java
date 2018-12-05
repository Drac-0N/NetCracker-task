package com.cracker.manual.controller;

import com.cracker.manual.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cracker.manual.repository.GroupRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    @Autowired
    private GroupRepository repository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable long id) {
        Optional<Group> group = repository.findById(id);
        if (group.isPresent()) {
            return ResponseEntity.ok(group.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Group> getGroups() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Group> saveGroup(@RequestBody Group group) {
        Group newGroup = repository.save(group);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newGroup.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@RequestBody Group group, @PathVariable long id) {

        Optional<Group> groupOptional = repository.findById(id);
        if (!groupOptional.isPresent())
            return ResponseEntity.notFound().build();

        group.setId(id);
        Group updatedGroup = repository.save(group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable long id) {
        repository.deleteById(id);
    }
}
