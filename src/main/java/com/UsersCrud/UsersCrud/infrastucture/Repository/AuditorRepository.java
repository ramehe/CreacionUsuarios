package com.UsersCrud.UsersCrud.infrastucture.Repository;

import com.UsersCrud.UsersCrud.infrastucture.Jpa.AuditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditorRepository extends JpaRepository <AuditorEntity, UUID> {
}
