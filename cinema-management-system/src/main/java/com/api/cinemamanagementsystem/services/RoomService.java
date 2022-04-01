package com.api.cinemamanagementsystem.services;

import com.api.cinemamanagementsystem.dtos.RoomDTO;
import com.api.cinemamanagementsystem.models.Room;
import com.api.cinemamanagementsystem.repositories.RoomRepository;
import com.api.cinemamanagementsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoomService {
    
    @Autowired
    RoomRepository repository;

    @Transactional(readOnly = true)
    public Page<RoomDTO> findAllPaged(Pageable pageable) {
        Page<Room> list = repository.findAll(pageable);
        return list.map(x -> new RoomDTO(x));
    }

    @Transactional(readOnly = true)
    public RoomDTO findById(Long id) {
        Optional<Room> obj = repository.findById(id);
        Room entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new RoomDTO(entity);
    }

    @Transactional
    public RoomDTO insert(RoomDTO dto) {
        Room entity = new Room();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new RoomDTO(entity);
    }
//
//    @Transactional
//    public RoomDTO update(Long id, RoomDTO dto) {
//        authService.validateIfUserAdmin(dto.getId());
//
//        try {
//            User entity = repository.getById(id);
//            copyDtoToEntity(dto,entity);
//            entity = repository.save(entity);
//            return new RoomDTO(entity);
//        } catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException("Id not found " + id);
//        }
//
//    }
//
//    public void delete(Long id) {
//        authService.validateIfUserAdmin(id);
//        try {
//            repository.deleteById(id);
//        } catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException("Id not found" + id);
//        } catch (DataIntegrityViolationException e) {
//            throw new DatabaseException("Integrity violation");
//        }

    private void copyDtoToEntity(RoomDTO dto, Room entity) {
        entity.setRoomName(dto.getRoomName());
        entity.setSeats(dto.getSeats());
    }
}
