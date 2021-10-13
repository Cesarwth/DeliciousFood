package com.atlen.test.hotel.services;

import com.atlen.test.hotel.model.Users;
import com.atlen.test.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
