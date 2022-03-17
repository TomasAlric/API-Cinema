package com.api.cinemamanagementsystem.dtos;

import com.api.cinemamanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    private LocalDateTime birthDate;

    @Email(message = "Please enter a valid email")
    private String email;

    private String cpf;

    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity){
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.birthDate = entity.getBirthDate();
        this.email = entity.getEmail();
        this.cpf = entity.getCpf();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

}
