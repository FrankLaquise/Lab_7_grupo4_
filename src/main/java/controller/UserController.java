package controller;

import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    UserRepository userRepository;
    @GetMapping("/listar")
    public List<Usuario> listaUsuarios() {
        return userRepository.findAll();

    }

}
