package com.api.cinemamanagementsystem.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomTests {

    @Test
    public void roomShouldHaveCorrectStructure() {

        Room entity = new Room();
        entity.setId(1L);
        entity.setRoomName("AB08");
        entity.setSeats(60);

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getRoomName());
        Assertions.assertNotNull(entity.getSeats());
    }
}
