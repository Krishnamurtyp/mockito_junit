package com.knf.dev.mockito.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.knf.dev.mockito.entity.User;
import com.knf.dev.mockito.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User();
        user.setName("sibin");
        user.setId(1);
        Mockito.when(userRepository.findByName(user.getName())).
                                 thenReturn(user);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "sibin";
        User found = userService.getUserByName(name);

        Assert.assertEquals(found.getName(), name);
    }
}
