package com.api.cinemamanagementsystem.repositories;

import com.api.cinemamanagementsystem.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository <Session, Long> {
}
