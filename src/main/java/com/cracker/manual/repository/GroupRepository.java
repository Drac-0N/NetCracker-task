package com.cracker.manual.repository;

import com.cracker.manual.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findAllByGroupId(Long id);
}
