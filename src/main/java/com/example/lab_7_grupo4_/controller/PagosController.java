package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PagosController {
    @Autowired
    UserRepository userRepository;
}
