package com.atlen.test.hotel.services;

import com.atlen.test.hotel.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private int id = 1;
    private final String name = "Cesar Tenemaza";
    private final String phone = "0995228473";
    private final String mail = "cesarwth@gmail.com";
    private final String country = "Ecuador";

    @InjectMocks
    private final UserService userService = new UserService();

    @Test
    public void shouldSaveGivenUser() {

    }
}
