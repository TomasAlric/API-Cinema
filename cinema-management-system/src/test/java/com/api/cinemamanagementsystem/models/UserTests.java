package com.api.cinemamanagementsystem.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserTests {

    @Test
    public void userShouldHaveStructureCorrect(){

        User entity = new User();
        entity.setId(1L);
        entity.setFirstName("Rinaldo");
        entity.setLastName("Dev");
        entity.setBirthDate(LocalDate.from(LocalDateTime.parse("2022-07-03T12:53:19")));
        entity.setCpf("23575398734");
        entity.setEmail("rinaldo@email.com");
        entity.setPassword("senha123");

        Assertions.assertEquals(1L, 1L);
        Assertions.assertEquals("Rinaldo", "Rinaldo");
        Assertions.assertEquals("dev", "dev");
        Assertions.assertEquals("2022-07-03T12:53:19", "2022-07-03T12:53:19");

    }
}
