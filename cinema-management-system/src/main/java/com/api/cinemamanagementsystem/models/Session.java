package com.api.cinemamanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sessions")
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movie;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private String room;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime dateSession;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket tickets;

    @OneToMany(mappedBy = "sessions")
    Set<Room> rooms = new HashSet<>();



}