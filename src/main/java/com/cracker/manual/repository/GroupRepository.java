package com.cracker.manual.repository;

import com.cracker.manual.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT ALL FROM Discipline_Group JOIN GroupsON ID_Group=ID_Group JOIN Disciplines ON ID_Disciplines=ID_Disciplines")
    List<String> getAllDisciplines();

    @Query("SELECT ALL FROM Discipline_Group JOIN GroupsON ID_Group=ID_Group JOIN Disciplines ON ID_Disciplines=ID_Disciplines WHERE ID_Group=") // как тут указать переменную я не понял
    List<String> getAllDisciplinesByGroup(int ID);
}
