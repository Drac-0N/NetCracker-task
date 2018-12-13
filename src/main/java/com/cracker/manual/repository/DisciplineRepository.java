package com.cracker.manual.repository;

import com.cracker.manual.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    //@Query("SELECT ALL FROM discipline d INNER JOIN discipline_groups dg ON d.id_discipline=ds.id_discipline WHERE dg.id_group=:id")
    //List<Discipline> getDisciplinesByGroupId(@Param("id") Long id);
    List<Discipline> getDisciplinesByGroupId(@Param("id") Long id);
}
