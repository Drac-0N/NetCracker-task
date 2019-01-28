package com.cracker.manual.service;

import com.cracker.manual.dto.ProfessorDTO;
import com.cracker.manual.entity.ProfessorRequest;
import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Group;
import com.cracker.manual.model.GroupDiscipline;
import com.cracker.manual.repository.DisciplineRepository;
import com.cracker.manual.repository.GroupDisciplineRepository;
import com.cracker.manual.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProfessorDisciplineService {
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

    public GroupDiscipline addProfessor(Long groupId, Long disciplineId, ProfessorRequest professor) {
        GroupDiscipline groupDiscipline = null;
        Optional<Group> group = groupRepository.findById(groupId);
        if(group.isPresent()) {
            Optional<Discipline> discipline = disciplineRepository.findById(disciplineId);
            if (discipline.isPresent()) {
                groupDiscipline = new GroupDiscipline();
                groupDiscipline.setGroup(group.get());
                groupDiscipline.setDiscipline(discipline.get());
                groupDiscipline.setProfessor(professor.getName());
                groupDiscipline = groupDisciplineRepository.save(groupDiscipline);
            }
        }
        return groupDiscipline;
    }

    public List<ProfessorDTO> getProfessor(Long groupId, Long disciplineId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if(group.isPresent()) {
            Optional<Discipline> discipline = disciplineRepository.findById(disciplineId);
            if (discipline.isPresent()) {
                return groupDisciplineRepository.findAllByGroupAndDiscipline(group.get(), discipline.get())
                        .stream()
                        .map(professor -> new ProfessorDTO(professor.getProfessor()))
                        .collect(Collectors.toList());
            }
        }
        return null;
    }
}
