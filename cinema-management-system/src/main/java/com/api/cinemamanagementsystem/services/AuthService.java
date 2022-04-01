package com.api.cinemamanagementsystem.services;

import com.api.cinemamanagementsystem.models.User;
import com.api.cinemamanagementsystem.repositories.UserRepository;
import com.api.cinemamanagementsystem.services.exceptions.ForbiddenException;
import com.api.cinemamanagementsystem.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated() {

        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateIfUserAdmin(Long userId) {
        User user = authenticated();
        if (!user.hasHole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}