package com.cracker.manual.repository;

import com.cracker.manual.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    //List<Discipline> getDisciplinesByGroupId(@Param("id") Long id);
    //@Query("SELECT ALL FROM discipline d INNER JOIN discipline_groups dg ON d.id_discipline=ds.id_discipline WHERE dg.id_group=:id")
    //List<Discipline> findAllGroupsByDisciplineId(Long id);
    //List<Discipline> findAllGroupsByID_Discipline(Long id);
//    Optional<Discipline> findAllByDisciplineId(Long id);
}

