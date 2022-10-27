package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Accione;
import com.example.lab_7_grupo4_.repository.AccioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin
public class AccionController {

    @Autowired
    AccioneRepository accioneRepository;

    @PostMapping(value ="/accione")
    public ResponseEntity<HashMap<String,String>> crearAccione(@RequestBody Accione accione){
        HashMap<String,String> hashMap = new HashMap<>();

        AccioneRepository.save(accione);

        hashMap.put("idCreado", String.valueOf(accione.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }
}
