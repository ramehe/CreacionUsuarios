package com.UsersCrud.UsersCrud.infrastucture.controller;


import com.UsersCrud.UsersCrud.application.useCases.UserService;
import com.UsersCrud.UsersCrud.domain.dto.in.User;
import com.UsersCrud.UsersCrud.domain.dto.out.ErrorGeneral;
import com.UsersCrud.UsersCrud.domain.exeption.ExeptionUsersCrud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/users")

public class Controller {


    private final UserService userService;


    public Controller(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<Object> create(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add("Campo '" + error.getField() + "': " + error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorGeneral(errors.toString()));
        }
        try {
            com.UsersCrud.UsersCrud.domain.dto.out.User userCreated = userService.createNew(user);
            return ResponseEntity.ok(userCreated);
        } catch (ExeptionUsersCrud ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorGeneral(ex.getMessage()));
        }
    }


}
