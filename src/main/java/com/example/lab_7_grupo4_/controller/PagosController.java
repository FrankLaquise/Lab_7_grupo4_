package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Pago;
import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.PagoRepository;
import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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


    @PostMapping("/registrar")
    public ResponseEntity<HashMap<String,String>> registrarPago(@RequestBody Pago pago){
        HashMap<String,String> hashMap = new HashMap<>();

        pagoRepository.save(pago);

        hashMap.put("idCreado", String.valueOf(pago.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }
}
