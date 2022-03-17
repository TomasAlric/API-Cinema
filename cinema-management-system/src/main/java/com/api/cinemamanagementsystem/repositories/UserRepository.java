package com.api.cinemamanagementsystem.repositories;

import com.api.cinemamanagementsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);

}
