package com.api.cinemamanagementsystem.services;

import com.api.cinemamanagementsystem.dtos.SessionDTO;
import com.api.cinemamanagementsystem.dtos.UserDTO;
import com.api.cinemamanagementsystem.models.Session;
import com.api.cinemamanagementsystem.models.User;
import com.api.cinemamanagementsystem.repositories.SessionRepository;
import com.api.cinemamanagementsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SessionService {
    
    @Autowired
    SessionRepository repository;

    @Transactional(readOnly = true)
    public Page<SessionDTO> findAllPaged(Pageable pageable) {
        Page<Session> list = repository.findAll(pageable);
        return list.map(x -> new SessionDTO(x));
    }

    @Transactional(readOnly = true)
    public SessionDTO findById(Long id) {
        Optional<Session> obj = repository.findById(id);
        Session entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new SessionDTO(entity); //, entity.getRooms()
    }

    @Transactional
    public SessionDTO insert(SessionDTO dto) {
        Session entity = new Session();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new SessionDTO(entity);
    }
//
//    @Transactional
//    public SessionDTO update(Long id, SessionDTO dto) {
//        authService.validateIfUserAdmin(dto.getId());
//
//        try {
//            User entity = repository.getById(id);
//            copyDtoToEntity(dto,entity);
//            entity = repository.save(entity);
//            return new SessionDTO(entity);
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

    private void copyDtoToEntity(SessionDTO dto, Session entity) {
        entity.setMovie(dto.getMovie());
        entity.setSynopsis(dto.getSynopsis());
        entity.setRoom(dto.getRoom());
        entity.setDateSession(dto.getDateSession());

    }
}
