package com.cracker.manual.controller;

import com.cracker.manual.model.Group;
import com.cracker.manual.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping(path = "/{groupId}")
    public ResponseEntity<Group> getGroup(@PathVariable long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if (group.isPresent()) {
            return ResponseEntity.ok(group.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group newGroup = groupRepository.save(group);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{groupId}").buildAndExpand(newGroup.getGroupId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<Group> updateGroup(@RequestBody Group group, @PathVariable long groupId) {

        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (!groupOptional.isPresent())
            return ResponseEntity.notFound().build();

        group.setGroupId(groupId);
        Group updatedGroup = groupRepository.save(group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping(path = "/{groupId}")
    public void deleteGroup(@PathVariable long groupId) {
        groupRepository.deleteById(groupId);

    }

//    @GetMapping(path = "/{groupId}/disciplines")
//    public List<DisciplineDTO> getDiscipline(@PathVariable Long groupId) {
//        Optional<Group> group = groupRepository.findAllByGroupId(groupId);
//        List<DisciplineDTO> disciplines = new ArrayList<>();
//        if (group.isPresent()) {
//            disciplines = group.get()
//                    .getDisciplines().stream()
//                    .map(discipline -> new DisciplineDTO(discipline.getName()))
//                    .collect(Collectors.toList());
//        }
//        return disciplines;
//    }
}

