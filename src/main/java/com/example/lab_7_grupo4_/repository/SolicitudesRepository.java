package com.example.lab_7_grupo4_.repository;

import com.example.lab_7_grupo4_.entity.Solicitudes;
import com.example.lab_7_grupo4_.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitudes,Integer>{

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE solicitudes SET solicitud_estado = 'pendiente' WHERE (id = ?1)")
    void actualizar_estado(Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE solicitudes SET solicitud_estado = 'aprobada' WHERE (id = ?1)")
    void AprobarSolicitud(Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE solicitudes SET solicitud_estado = 'denegada' WHERE (id = ?1)")
    void DenegarSolicitud(Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "DELETE FROM solicitudes WHERE (id = ?1)")
    void EliminarSolicitud(Integer id);
}
