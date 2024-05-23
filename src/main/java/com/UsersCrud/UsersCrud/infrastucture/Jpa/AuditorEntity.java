package com.UsersCrud.UsersCrud.infrastucture.Jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AuditorEntity {

    @Id
    private UUID UserId;
    private String DateCreated;
    private String DateModificated;
    private String LastLogin;
    private String Token;
    private Boolean IsActive;


    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
