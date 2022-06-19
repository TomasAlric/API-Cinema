package com.api.cinemamanagementsystem.services;

import com.api.cinemamanagementsystem.dtos.TicketDTO;
import com.api.cinemamanagementsystem.models.Session;
import com.api.cinemamanagementsystem.models.Ticket;
import com.api.cinemamanagementsystem.models.User;
import com.api.cinemamanagementsystem.repositories.RoomRepository;
import com.api.cinemamanagementsystem.repositories.TicketRepository;
import com.api.cinemamanagementsystem.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private RoomRepository roomRepository;

    private ModelMapper mapper;

    @Transactional(readOnly = true)
    public Page<TicketDTO> findAllPaged(Pageable pageable) {
        Page<Ticket> list = repository.findAll(pageable);
        return list.map(TicketDTO::new);
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

    private void copyDtoToEntity(TicketDTO dto, Ticket entity) {
        entity.setDiscount(dto.getDiscount());
        entity.setSeat(dto.getSeat());
        entity.setValueOfTicket(dto.getValueOfTicket());
        Session session = new Session();
        session.setId(dto.getSessionDTO().getId());
        User user = new User();
        user.setId(dto.getUserDTO().getId());
        entity.setSession(session);
        entity.setUser(user);
    }

    /**
     * Vende um ingresso garantindo a quantidade disponível de assentos disponíveis (considerando a capacidade da sala).
     *
     * @param {@link TicketDTO}
     */
    public TicketDTO buyNewTicket(TicketDTO dto) {
        final var room = roomRepository.findById(dto.getSessionDTO().getRoomDTO().getId());

        final var totalSeats = room.get().getSeats();

        final var totalTicketSoldByRoom = repository.countSoldTicketsBySessionAndRoom(dto.getSessionDTO().getRoomDTO().getId());

        if (totalTicketSoldByRoom >= totalSeats) {
            throw new RuntimeException("No more seats available");
        }
        return insert(dto);
    }
}