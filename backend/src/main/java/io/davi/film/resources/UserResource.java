package io.davi.film.resources;

import io.davi.film.dto.UserDTO;
import io.davi.film.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users/profile")
public class UserResource {

    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
    @GetMapping
    public ResponseEntity<UserDTO> findLoggedUser() {
        UserDTO dto = service.findByUser();
        return ResponseEntity.ok().body(dto);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}