package com.cracker.manual.controller;

import com.cracker.manual.dto.AssesmentDTO;
import com.cracker.manual.entity.AssesmentRequest;
import com.cracker.manual.model.StudentDiscipline;
import com.cracker.manual.service.AssessmentStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/assessments")
public class AssessmentStudentController {

    @Autowired
    private AssessmentStudentService assessmentService;

    @GetMapping(path = "/{studentId}/{disciplineId}")
    public List<AssesmentDTO> getStudentAssessments(@PathVariable Long studentId,
                                                    @PathVariable Long disciplineId) {

        return assessmentService.getAssesment(studentId, disciplineId);
    }

    @PostMapping(path = "/{studentId}/{disciplineId}")
    public StudentDiscipline setMarkByDate(@PathVariable Long studentId,
                                           @PathVariable Long disciplineId,
                                           @RequestBody AssesmentRequest assesment) {
        return assessmentService.addAssesment(studentId, disciplineId, assesment);
    }
}
