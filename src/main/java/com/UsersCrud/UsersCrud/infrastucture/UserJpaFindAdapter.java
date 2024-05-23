package com.UsersCrud.UsersCrud.infrastucture;

import com.UsersCrud.UsersCrud.domain.port.FindUserPort;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;
import com.UsersCrud.UsersCrud.infrastucture.Repository.UserRepostory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserJpaFindAdapter implements FindUserPort {

    private final UserRepostory userRepostory;


    public UserJpaFindAdapter(UserRepostory userRepostory) {
        this.userRepostory = userRepostory;

    }

    @Override
    public Boolean findMail(String email) {

        return  userRepostory.existsByEmail(email);

    }



}
