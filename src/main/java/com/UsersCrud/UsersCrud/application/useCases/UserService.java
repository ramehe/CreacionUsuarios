package com.UsersCrud.UsersCrud.application.useCases;

import com.UsersCrud.UsersCrud.domain.dto.out.User;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;

import java.util.Optional;
import java.util.UUID;


public interface UserService {

    User createNew(com.UsersCrud.UsersCrud.domain.dto.in.User user);

}
