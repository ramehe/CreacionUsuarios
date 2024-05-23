package com.UsersCrud.UsersCrud.application.service;

import com.UsersCrud.UsersCrud.application.useCases.UserService;
import com.UsersCrud.UsersCrud.domain.dto.in.User;
import com.UsersCrud.UsersCrud.domain.exeption.ExeptionUsersCrud;
import com.UsersCrud.UsersCrud.domain.port.CreateUserport;
import com.UsersCrud.UsersCrud.domain.port.FindUserPort;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.PhonesEntity;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserCreateService implements UserService {

    private static final String ERROR_MAIL = "El correo ya Registrado";
    private static final String ID_NOT_FOUND = "Id no encontrado";
    private final CreateUserport createUserport;
    private final FindUserPort findUserPort;


    public UserCreateService(CreateUserport createUserport, FindUserPort findUserPort) {
        this.createUserport = createUserport;
        this.findUserPort = findUserPort;
    }


    @Override
    public com.UsersCrud.UsersCrud.domain.dto.out.User createNew(User user) {

         if (CheckEmail(user.getEmail())) {
            throw new ExeptionUsersCrud(ERROR_MAIL);
        } else {
            UserEntity userEnty = createUserport.create(user);
            return mapUserDto(userEnty);
        }


    }






    private com.UsersCrud.UsersCrud.domain.dto.out.User mapUserDto(UserEntity userEnty) {

        return com.UsersCrud.UsersCrud.domain.dto.out.User.builder()
                .id(String.valueOf(userEnty.getId()))
                .token(userEnty.getAuditor().getToken())
                .isActive(userEnty.getAuditor().getIsActive())
                .created(userEnty.getAuditor().getDateCreated())
                .modified(userEnty.getAuditor().getDateModificated())
                .lastLogin(userEnty.getAuditor().getLastLogin())
                .build();
    }

    private boolean CheckEmail(String email) {
        return findUserPort.findMail(email);
    }



}

