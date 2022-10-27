package com.example.lab_7_grupo4_.controller;

import com.example.lab_7_grupo4_.entity.Solicitudes;
import com.example.lab_7_grupo4_.entity.Usuario;
import com.example.lab_7_grupo4_.repository.SolicitudesRepository;
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
public class SolicitudesController {
    @Autowired
    SolicitudesRepository solicitudesRepository;

    @ResponseBody
    @GetMapping(value = "/solicitudes/listar")
    public List<Solicitudes> listaUsuarios() {
        return solicitudesRepository.findAll();
    }
    @ResponseBody
    @PostMapping(value = "/solicitudes/registrar")
    public ResponseEntity<HashMap<String,String>> crearSolicitud(@RequestBody Solicitudes solicitud){
        HashMap<String,String> hashMap = new HashMap<>();

        solicitudesRepository.save(solicitud);
        solicitudesRepository.actualizar_estado(solicitud.getId());
        hashMap.put("Monto solicitado", String.valueOf(solicitud.getSolicitudMonto()));
        hashMap.put("id", String.valueOf(solicitud.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

    @PutMapping(value = "/solicitudes/aprobarSolicitud")
    public ResponseEntity<HashMap<String,String>> aprobarSolicitud(@RequestBody Solicitudes solicitud,
                                                                                 @RequestParam("idSolicitud") Integer idStr){
        HashMap<String,String> hashMap = new HashMap<>();

        Optional<Solicitudes> optsolic = solicitudesRepository.findById(solicitud.getId());
        if(optsolic.isPresent()){
            Solicitudes solicitudd = optsolic.get();
            if(solicitudd.getSolicitudEstado() == "pendiente") {
                solicitudd.setSolicitudEstado("aprobada");
                solicitudesRepository.AprobarSolicitud(idStr);
                hashMap.put("id solicitud",String.valueOf(solicitudd.getId()));
            }else{
                hashMap.put("solicitud ya atendida",String.valueOf(solicitudd.getId()));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
        }else{
            hashMap.put("status","error");
            hashMap.put("msg","La solicitud no existe");
            return ResponseEntity.ok(hashMap);
        }
    }

    @PutMapping(value = "/solicitudes/denegarSolicitud")
    public ResponseEntity<HashMap<String,String>> denegarSolicitud(@RequestBody Solicitudes solicitud,
                                                                   @RequestParam("idSolicitud") Integer idStr){
        HashMap<String,String> hashMap = new HashMap<>();

        Optional<Solicitudes> optsolic = solicitudesRepository.findById(solicitud.getId());
        if(optsolic.isPresent()){
            Solicitudes solicitudd = optsolic.get();
            if(solicitudd.getSolicitudEstado() == "pendiente") {
                solicitudd.setSolicitudEstado("denegada");
                solicitudesRepository.DenegarSolicitud(idStr);
                hashMap.put("id solicitud",String.valueOf(solicitudd.getId()));
            }else{
                hashMap.put("solicitud ya atendida",String.valueOf(solicitudd.getId()));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
        }else{
            hashMap.put("status","error");
            hashMap.put("msg","La solicitud no existe");
            return ResponseEntity.ok(hashMap);
        }
    }

    @PutMapping(value = "/solicitudes/eliminar")
    public ResponseEntity<HashMap<String,String>> eliminarSolicitud(@RequestBody Solicitudes solicitud,
                                                                   @RequestParam("idSolicitud") Integer idStr){
        HashMap<String,String> hashMap = new HashMap<>();

        Optional<Solicitudes> optsolic = solicitudesRepository.findById(solicitud.getId());
        if(optsolic.isPresent()){
            Solicitudes solicitudd = optsolic.get();
            if(solicitudd.getSolicitudEstado() == "denegada") {
                solicitudesRepository.EliminarSolicitud(idStr);
                hashMap.put("id solicitud borrada",String.valueOf(solicitudd.getId()));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
        }else{
            hashMap.put("status","error");
            hashMap.put("msg","La solicitud no existe");
            return ResponseEntity.ok(hashMap);
        }
    }
}
