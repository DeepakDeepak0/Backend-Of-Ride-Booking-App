package com.codeWithMe.Uber.Uber.dto;

import com.codeWithMe.Uber.Uber.entities.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private Set<Role> roles;

}
