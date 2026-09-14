package com.example.myfirstProject.service;


import com.example.myfirstProject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static  org.mockito.Mockito.*;

    @SpringBootTest
    public class UserDetailsServiceImplTests {

        @InjectMocks
        private UserDetailsServiceImpl userDetailsService;

        @Mock
        private UserRepository userRepository;

        @BeforeEach
        void setUp(){
            MockitoAnnotations.initMocks(this);
        }

        @Disabled
        @Test
        void loadUserByUsernameTest(){
            when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn((com.example.myfirstProject.entity.User) User.builder().username("Abdullah").password("inrinrick").roles(String.valueOf(new ArrayList<>())).build());
            UserDetails user = userDetailsService.loadUserByUsername("Abdullah");
            Assertions.assertNotNull(user);
        }
    }

