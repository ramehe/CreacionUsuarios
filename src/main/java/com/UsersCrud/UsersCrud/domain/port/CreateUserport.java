package com.UsersCrud.UsersCrud.domain.port;

import com.UsersCrud.UsersCrud.domain.dto.in.User;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;

public interface CreateUserport {

    UserEntity create(User request);
}
