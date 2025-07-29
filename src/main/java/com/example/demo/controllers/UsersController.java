package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository repo;

    public UsersController(UsersRepository repo) {
        this.repo = repo;
    }

    //Get list Users
    @GetMapping
    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    //Get one User
    @GetMapping("/{id}")
    public Users getOneUser(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    //Create User
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return repo.save(user);
    }
}
