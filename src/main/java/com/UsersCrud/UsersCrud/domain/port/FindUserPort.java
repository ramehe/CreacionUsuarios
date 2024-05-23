package com.UsersCrud.UsersCrud.domain.port;


import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;

import java.util.UUID;

public interface FindUserPort {
    Boolean findMail(String email);



}
