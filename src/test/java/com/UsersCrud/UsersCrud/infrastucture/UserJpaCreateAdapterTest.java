package com.UsersCrud.UsersCrud.infrastucture;

import com.UsersCrud.UsersCrud.domain.dto.in.Phones;
import com.UsersCrud.UsersCrud.domain.dto.in.User;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.AuditorEntity;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.PhonesEntity;
import com.UsersCrud.UsersCrud.infrastucture.Jpa.UserEntity;
import com.UsersCrud.UsersCrud.infrastucture.Repository.AuditorRepository;
import com.UsersCrud.UsersCrud.infrastucture.Repository.PhonesRepository;
import com.UsersCrud.UsersCrud.infrastucture.Repository.UserRepostory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserJpaCreateAdapterTest {
    @Mock
    private UserRepostory userRepostory;

    @Mock
    private PhonesRepository phonesRepository;

    @Mock
    private AuditorRepository auditorRepository;

    @InjectMocks
    private UserJpaCreateAdapter userJpaCreateAdapter;

    @Test
    public void testCreate() {
        User request = new User();

        request.setName("Test Name");
        request.setEmail("test@example.com");
        request.setPassword("password");
        List<Phones> phonesList = new ArrayList<>();
        Phones phone = new Phones();
        phone.setNumber("123456789");
        phone.setCitycode("1");
        phone.setContrycode("22");
        phonesList.add(phone);
        request.setPhones(phonesList);

        List<PhonesEntity> phonesEntities = new ArrayList<>();
        phonesEntities.add(PhonesEntity.builder().number("123").contrycode("123").build());
        phonesEntities.add(PhonesEntity.builder().number("456").contrycode("456").build());

        UserEntity savedUser = new UserEntity();
        savedUser.setId(UUID.randomUUID());
        savedUser.setName(request.getName());
        savedUser.setEmail(request.getEmail());
        savedUser.setPhones(phonesEntities);
        savedUser.setAuditor(AuditorEntity.builder().UserId(UUID.randomUUID()).DateCreated("12313").build());

        when(userRepostory.save(ArgumentMatchers.any(UserEntity.class))).thenReturn(savedUser);

        UserEntity result = userJpaCreateAdapter.create(request);

        assertNotNull(result);
        assertEquals(savedUser.getId(), result.getId());
        assertEquals(savedUser.getName(), result.getName());
        assertEquals(savedUser.getEmail(), result.getEmail());
    }



}