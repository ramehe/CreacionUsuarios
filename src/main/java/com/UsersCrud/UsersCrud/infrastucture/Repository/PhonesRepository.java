package com.UsersCrud.UsersCrud.infrastucture.Repository;

import com.UsersCrud.UsersCrud.infrastucture.Jpa.PhonesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<PhonesEntity , String> {
}
