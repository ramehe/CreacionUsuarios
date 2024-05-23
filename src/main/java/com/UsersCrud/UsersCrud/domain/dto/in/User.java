package com.UsersCrud.UsersCrud.domain.dto.in;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class User {
    @NotNull(message = "nombre vacio")
    private String name;
    @NotNull(message = "email Vacio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String email;
    @NotNull(message = "password Vacio")
    private String password;
    @Valid
    private List<Phones>  phones;
}
