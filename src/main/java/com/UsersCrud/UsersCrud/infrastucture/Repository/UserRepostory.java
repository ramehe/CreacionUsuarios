package com.UsersCrud.UsersCrud.infrastucture.Repository;

import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends JpaRepository <UserEntity, String>{
    Boolean existsByEmail(String email);
}
