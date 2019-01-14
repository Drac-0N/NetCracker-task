package com.cracker.manual.service;

import com.cracker.manual.dto.GroupDTO;
import com.cracker.manual.model.Discipline;
import com.cracker.manual.repository.DisciplineRepository;
import com.cracker.manual.repository.GroupDisciplineRepository;
import com.cracker.manual.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GroupDisciplineService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private GroupDisciplineRepository groupDisciplineRepository;
    /*
    public List<GroupDTO> getGroups(@PathVariable Long disciplineId) {
        Optional<Discipline> discipline = disciplineRepository.findAllByDisciplineId(disciplineId);
        List<GroupDTO> groups = new ArrayList<>();
        if (discipline.isPresent()) {
            groups = discipline.get()
                    .getGroups().stream()
                    .map(group -> new GroupDTO(group.getName()))
                    .collect(Collectors.toList());
        }
        return groups;
    }
    */
}
