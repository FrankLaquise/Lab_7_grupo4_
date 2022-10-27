package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Pago;
import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.PagoRepository;
import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/pagos")

public class PagosController {
    @Autowired
    PagoRepository pagoRepository;
    @ResponseBody
    @GetMapping(value = "/listarpago")
    public List<Pago> listaPagos() {
        return pagoRepository.findAll();
    }
}
