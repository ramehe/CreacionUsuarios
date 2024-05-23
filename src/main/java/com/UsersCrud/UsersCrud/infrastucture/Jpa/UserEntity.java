package com.UsersCrud.UsersCrud.infrastucture.Jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "number",cascade = CascadeType.ALL)
    private List<PhonesEntity> phones;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AuditorEntity auditor;

}
