package com.api.cinemamanagementsystem.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class SessionTests {

    @Test
    public void sessionShouldHaveCorrectStructure(){

        Session entity = new Session();
        entity.setId(1L);
        entity.setMovie("Doctor Strange");
        entity.setSynopsis("Magic and Action");
        entity.setDateSession(LocalDateTime.parse("2022-07-03T12:53:19"));

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getMovie());
        Assertions.assertNotNull(entity.getSynopsis());
        Assertions.assertNotNull(entity.getDateSession());
    }

}
