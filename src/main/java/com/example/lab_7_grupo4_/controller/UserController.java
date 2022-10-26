package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @ResponseBody
    @GetMapping(value = "/listar")
    public List<Usuario> listaUsuarios() {
        return userRepository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/listar2")
    public String lista1Usuarios() {
        return "holamundo";
    }

}
