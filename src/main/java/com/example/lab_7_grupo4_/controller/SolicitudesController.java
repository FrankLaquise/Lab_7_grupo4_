package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Solicitudes;
import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.SolicitudesRepository;
import com.example.lab_7_grupo4_.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class SolicitudesController {
    @Autowired
    SolicitudesRepository solicitudesRepository;

    @ResponseBody
    @PostMapping(value = "/solicitudes/registrar")
    public ResponseEntity<HashMap<String,String>> crearSolicitud(@RequestBody Solicitudes solicitud){
        HashMap<String,String> hashMap = new HashMap<>();

        solicitudesRepository.save(solicitud);

        hashMap.put("idCreado", String.valueOf(solicitud.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

}
