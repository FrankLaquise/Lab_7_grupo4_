package com.example.lab_7_grupo4_.repository;

import com.example.lab_7_grupo4_.entity.Solicitudes;
import com.example.lab_7_grupo4_.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitudes,Integer>{

}
