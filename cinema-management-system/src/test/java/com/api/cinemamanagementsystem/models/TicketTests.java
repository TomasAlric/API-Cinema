package com.api.cinemamanagementsystem.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTests {

    @Test
    public void ticketShouldHaveCorrectStructure(){

        Ticket entity = new Ticket();
        entity.setId(1L);
        entity.setValueOfTicket(100.0);
        entity.setDiscount(50.0);
        entity.setSeat(60);

        Assertions.assertEquals(1L, 1L);
        Assertions.assertEquals(100.0, 100.0);
        Assertions.assertEquals(50.0, 50.0);
        Assertions.assertEquals(60, 60);
    }
}
