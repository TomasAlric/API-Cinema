package com.api.cinemamanagementsystem.repositories;

import com.api.cinemamanagementsystem.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository <Room, Long> {

}
