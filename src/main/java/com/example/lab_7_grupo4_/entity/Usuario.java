package com.example.lab_7_grupo4_.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;

    @Size(max = 45)
    @Column(name = "apellido", length = 45)
    private String apellido;

    @Size(max = 45)
    @Column(name = "correo", length = 45)
    private String correo;

    @Size(max = 45)
    @Column(name = "username", length = 45)
    private String username;

    @Size(max = 45)
    @Column(name = "password", length = 45)
    private String password;

    @Size(max = 45)
    @Column(name = "estado_logico", length = 45)
    private String estadoLogico;

    @NotNull
    @ManyToOne( optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol_id;

    @Column(name = "fecha_registro")
    private Instant fecha_registro;





}