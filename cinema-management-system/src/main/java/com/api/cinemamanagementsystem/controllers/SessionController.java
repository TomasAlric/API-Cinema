package com.api.cinemamanagementsystem.controllers;

import com.api.cinemamanagementsystem.dtos.SessionDTO;
import com.api.cinemamanagementsystem.dtos.UserDTO;
import com.api.cinemamanagementsystem.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {

    @Autowired
    private SessionService service;

    @GetMapping
    public ResponseEntity<Page<SessionDTO>> findAll(Pageable pageable) {
        final var list = service.findAllPaged(pageable);
        if (list.getTotalElements() == 0)
            return ResponseEntity.noContent().build();

        /**
         * 201 -> novo item é criado
         * 204 -> quando não há retorno (GET ?queryParams) ou quando deleta algum item.
         * 200 -> OK (retornou item)
         * 404 -> não encontrado (path param)
         * 401 -> não autenticado (vc n tá logado)
         * 403 -> vc n tem  permissão (forbidden)
         * 500 -> evitar, mas acontece!
         * 302 -> not modfied (
         *  - CACHE_CONTROL
         *  - TTL
         *  - eTAG (hash do conteúdo)
         *   - LER SOBRE CACHEAMENTO: https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Caching
         */

        return ResponseEntity.ok().body(list);
    }
    /**
    GET /SESSIONS?page=2&size=20 ->204
      GET /sessions/200 -> se não houver item, retorna um 404.
     **/

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
