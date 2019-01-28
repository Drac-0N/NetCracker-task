package com.cracker.manual.repository;

import com.cracker.manual.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByGroupId(Long id);
}
