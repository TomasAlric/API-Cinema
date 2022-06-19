package com.api.cinemamanagementsystem.services;

import com.api.cinemamanagementsystem.dtos.SessionDTO;
import com.api.cinemamanagementsystem.models.Room;
import com.api.cinemamanagementsystem.models.Session;
import com.api.cinemamanagementsystem.repositories.SessionRepository;
import com.api.cinemamanagementsystem.services.exceptions.DatabaseException;
import com.api.cinemamanagementsystem.services.exceptions.IntegrityViolationException;
import com.api.cinemamanagementsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repository;

    @Transactional(readOnly = true)
    public Page<SessionDTO> findAllPaged(Pageable pageable) {
        Page<Session> list = repository.findAll(pageable);
        return list.map(SessionDTO::new);
    }

    @Transactional(readOnly = true)
    public SessionDTO findById(Long id) {
        Optional<Session> obj = repository.findById(id);
        Session entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new SessionDTO(entity);
    }

    @Transactional
    public SessionDTO insert(SessionDTO dto) {
        try {

            Session entity = new Session();
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new SessionDTO(entity);
        } catch (DataIntegrityViolationException e) {
            throw new IntegrityViolationException("Oh no");
        }
    }

    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(SessionDTO dto, Session entity) {
        entity.setMovie(dto.getMovie());
        entity.setSynopsis(dto.getSynopsis());
        entity.setDateSession(dto.getDateSession());
        Room room = new Room();
        room.setId(dto.getRoomDTO().getId());
        entity.setRoom(room);
    }
}