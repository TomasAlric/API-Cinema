package com.api.cinemamanagementsystem.dtos;

import com.api.cinemamanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Required field")
    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    @Email(message = "Please enter a valid email")
    private String email;

    private String cpf;

    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        birthDate = entity.getBirthDate();
        email = entity.getEmail();
        cpf = entity.getCpf();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }
}