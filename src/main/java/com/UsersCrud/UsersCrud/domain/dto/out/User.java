package com.UsersCrud.UsersCrud.domain.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {


    private String id;
    private String created;
    private String modified;
    @JsonProperty(defaultValue = "lastlogin")
    private String lastLogin;
    private String token;
    @JsonProperty(defaultValue = "isactive")
    private Boolean isActive;

}
