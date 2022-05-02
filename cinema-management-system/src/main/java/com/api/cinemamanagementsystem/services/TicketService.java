package com.api.cinemamanagementsystem.services;

import com.api.cinemamanagementsystem.dtos.TicketDTO;
import com.api.cinemamanagementsystem.dtos.UserDTO;
import com.api.cinemamanagementsystem.models.Ticket;
import com.api.cinemamanagementsystem.repositories.RoomRepository;
import com.api.cinemamanagementsystem.repositories.TicketRepository;
import com.api.cinemamanagementsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public Page<TicketDTO> findAllPaged(Pageable pageable) {
        Page<Ticket> list = repository.findAll(pageable);
        return list.map(x -> new TicketDTO(x));
    }

    @Transactional(readOnly = true)
    public TicketDTO findById(Long id) {
        Optional<Ticket> obj = repository.findById(id);
        Ticket entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new TicketDTO(entity);
    }

    @Transactional
    public TicketDTO insert(TicketDTO dto) {
        Ticket entity = new Ticket();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new TicketDTO(entity);
    }
//
//    @Transactional
//    public TicketDTO update(Long id, TicketDTO dto) {
//        authService.validateIfUserAdmin(dto.getId());
//
//        try {
//            User entity = repository.getById(id);
//            copyDtoToEntity(dto,entity);
//            entity = repository.save(entity);
//            return new TicketDTO(entity);
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

    private void copyDtoToEntity(TicketDTO dto, Ticket entity) {
        entity.setDiscount(dto.getDiscount());
        entity.setSeat(dto.getSeat());
        entity.setValueOfTicket(dto.getValueOfTicket());
    }

    /**
     * Vende um ingresso garantindo a quantidade disponível de assentos diponíveis (considerando a capacidade da sala).
     *
     * @param {@link TicketDTO}
     */
    public TicketDTO buyNewTicket(TicketDTO dto) {
        final var room = roomRepository.findById(dto.getSessionDTO().getRoomDTO().getId());
        final var totalSeats = room.get().getSeats();

        final var totalTicketSoldByRoom = repository.coundSoldTicketsBySessionAndRom(dto.getSessionDTO().getRoomDTO().getId());

        if (totalSeats >= totalTicketSoldByRoom) {
            throw new RuntimeException("Não há mais assentos disponíveis");
        }

        return insert(dto);
    }
}
