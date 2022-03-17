package com.api.cinemamanagementsystem.repositories;

import com.api.cinemamanagementsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
}
