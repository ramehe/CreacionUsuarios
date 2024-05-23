package com.UsersCrud.UsersCrud.infrastucture;

import com.UsersCrud.UsersCrud.domain.dto.in.User;
import com.UsersCrud.UsersCrud.domain.port.CreateUserport;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.AuditorEntity;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.PhonesEntity;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;
import com.UsersCrud.UsersCrud.infrastucture.Repository.AuditorRepository;
import com.UsersCrud.UsersCrud.infrastucture.Repository.PhonesRepository;
import com.UsersCrud.UsersCrud.infrastucture.Repository.UserRepostory;
import jakarta.persistence.GenerationType;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserJpaCreateAdapter implements CreateUserport {


    private final UserRepostory userRepostory;
    private final PhonesRepository phonesRepository;
    private final AuditorRepository auditorRepository;


    public UserJpaCreateAdapter(UserRepostory userRepostory, PhonesRepository phonesRepository, AuditorRepository auditorRepository) {
        this.userRepostory = userRepostory;
        this.phonesRepository = phonesRepository;
        this.auditorRepository = auditorRepository;
    }




    @Override
    public UserEntity create(User request) {

        UUID key = UUID.randomUUID();


        return userRepostory.save( UserEntity.builder()
                            .id(key)
                        .name(request.getName())
                        .email(request.getEmail())
                        .phones(buildPhones(request))
                        .password(request.getPassword())
                        .auditor(buildAuditor(key ,request ))
                .build());



    }

    private AuditorEntity buildAuditor(UUID key, User request) {

        UUID token = UUID.randomUUID();

        return auditorRepository.save(AuditorEntity.builder()
                        .UserId(key)
                        .Token(String.valueOf(token))
                        .DateCreated(String.valueOf(LocalDateTime.now()))
                        .DateModificated(String.valueOf(LocalDateTime.now()))
                        .IsActive(Boolean.TRUE)
                        .LastLogin(String.valueOf(LocalDateTime.now()))
                .build());

    }

    private List<PhonesEntity> buildPhones(User request) {
            List<PhonesEntity> phonesEntities = request.getPhones().stream()
                                .map(phones1 -> PhonesEntity.builder()
                                        .number(phones1.getNumber())
                                        .cityCode(phones1.getCitycode())
                                        .contrycode(phones1.getCitycode())
                                        .build()).collect(Collectors.toList());

            phonesEntities = phonesRepository.saveAll(phonesEntities);

                return phonesEntities;
        }

    }




