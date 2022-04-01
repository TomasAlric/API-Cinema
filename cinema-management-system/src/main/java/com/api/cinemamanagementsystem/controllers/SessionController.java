package com.api.cinemamanagementsystem.controllers;

import com.api.cinemamanagementsystem.dtos.SessionDTO;
import com.api.cinemamanagementsystem.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "sessions")
public class SessionController {

    @Autowired
    SessionService service;

    @GetMapping
    public ResponseEntity<Page<SessionDTO>> findAll(Pageable pageable) {

        Page<SessionDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SessionDTO> findById(@PathVariable Long id) {
        SessionDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<SessionDTO> insert(@RequestBody SessionDTO dto) {

        SessionDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }
}
