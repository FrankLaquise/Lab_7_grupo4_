package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @ResponseBody
    @GetMapping(value = "/listar")
    public List<Usuario> listaUsuarios() {
        return userRepository.findAll();
    }



    @PostMapping("/crear")
    public ResponseEntity<HashMap<String,String>> crearProducto(@RequestBody Usuario usuario){
        HashMap<String,String> hashMap = new HashMap<>();

        userRepository.save(usuario);

        hashMap.put("idCreado", String.valueOf(usuario.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }
}
