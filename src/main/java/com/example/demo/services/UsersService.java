package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;

public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
