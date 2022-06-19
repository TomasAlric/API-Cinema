package com.api.cinemamanagementsystem.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleTests {

    @Test
    public void userShouldHaveCorrectStructure(){
        Role entity = new Role();
        entity.setId(1L);
        entity.setAuthority("ADMIN");

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getAuthority());
    }
}
