package com.example.demo.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.UsersCreateDTO;
import com.example.demo.models.DatosPersonales;
import com.example.demo.models.Users;
import com.example.demo.repositories.HabitacionesRepository;
import com.example.demo.repositories.ReservacionesRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository, ReservacionesRepository reservacionesRepository,
            HabitacionesRepository habitacionesRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    // Create user
    public Users createUser(UsersCreateDTO dto) {
        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        DatosPersonales datos = new DatosPersonales();
        datos.setNombre(dto.getDatosPersonalesDTO().getNombre());
        datos.setApellidoPaterno(dto.getDatosPersonalesDTO().getApellidoPaterno());
        datos.setApellidoMaterno(dto.getDatosPersonalesDTO().getApellidoMaterno());

        // Relación en ambos sentidos
        user.setDatosPersonales(datos);
        datos.setUsers(user);

        return usersRepository.save(user);
    }
}
