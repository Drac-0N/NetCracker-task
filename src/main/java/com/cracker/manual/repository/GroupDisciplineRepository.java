package com.cracker.manual.repository;


import com.cracker.manual.model.Discipline;
import com.cracker.manual.model.Group;
import com.cracker.manual.model.GroupDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupDisciplineRepository extends JpaRepository<GroupDiscipline, Long> {
    //List<GroupDiscipline> findAllByGroupAndDiscipline(Group group, Discipline discipline);
}
