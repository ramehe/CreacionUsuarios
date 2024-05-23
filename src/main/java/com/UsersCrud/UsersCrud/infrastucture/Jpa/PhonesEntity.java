package com.UsersCrud.UsersCrud.infrastucture.Jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Entity

@NoArgsConstructor
@AllArgsConstructor
public class PhonesEntity {
    @Id
    private String number;
    private String cityCode;
    private String contrycode;



}
