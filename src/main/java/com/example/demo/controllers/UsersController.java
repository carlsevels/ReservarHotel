package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.DatosPersonalesDTO;
import com.example.demo.DTO.UsersCreateDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.models.DatosPersonales;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository repo;
    private final UsersService usersService;

    public UsersController(UsersRepository repo, UsersService usersService) {
        this.repo = repo;
        this.usersService = usersService;
    }

    // Get list Users
    @GetMapping
    public List<UsersDTO> getAllUsers() {
        List<Users> usuarios = repo.findAll();
        return usuarios.stream()
                .map(u -> {
                    DatosPersonales dp = u.getDatosPersonales();
                    DatosPersonalesDTO dpDTO = new DatosPersonalesDTO(
                            dp.getNombreString(),
                            dp.getApellidoPaternoString(),
                            dp.getApellidoMaternoString());
                    return new UsersDTO(u.getEmail(), dpDTO);
                })
                .toList();
    }

    // Get one User
    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getOneUser(@PathVariable Long id) {
        Optional<Users> optionalUser = repo.findById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            DatosPersonales dp = user.getDatosPersonales();

            DatosPersonalesDTO dpDTO = new DatosPersonalesDTO(
                    dp.getNombreString(),
                    dp.getApellidoPaternoString(),
                    dp.getApellidoMaternoString());

            UsersDTO dto = new UsersDTO(user.getEmail(), dpDTO);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create User
    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody UsersCreateDTO dto) {
        usersService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
    }
}
