package com.cracker.manual.controller;

import com.cracker.manual.dto.ProfessorDTO;
import com.cracker.manual.entity.ProfessorRequest;
import com.cracker.manual.model.GroupDiscipline;
import com.cracker.manual.service.ProfessorDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorDisciplineController {

    @Autowired
    private ProfessorDisciplineService professorService;

    @GetMapping(path = "/{groupId}/{disciplineId}")
    public List<ProfessorDTO> getDisciplineProfessor(@PathVariable Long groupId,
                                                    @PathVariable Long disciplineId) {

        return professorService.getProfessor(groupId, disciplineId);
    }

    @PostMapping(path = "/{groupId}/{disciplineId}")
    public GroupDiscipline setDisciplineProfessor(@PathVariable Long groupId,
                                         @PathVariable Long disciplineId,
                                         @RequestBody ProfessorRequest professor) {
        return professorService.addProfessor(groupId, disciplineId, professor);
    }
}
