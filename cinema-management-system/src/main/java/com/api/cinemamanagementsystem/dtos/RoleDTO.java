package com.api.cinemamanagementsystem.dtos;

import com.api.cinemamanagementsystem.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String authority;

    public RoleDTO (Role role){
        id = role.getId();
        authority = role.getAuthority();
    }
}
