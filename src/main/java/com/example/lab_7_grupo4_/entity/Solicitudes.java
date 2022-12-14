package com.example.lab_7_grupo4_.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "solicitudes")
public class Solicitudes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "solicitud_producto", length = 45)
    private String solicitudProducto;

    @Column(name = "solicitud_monto")
    private Double solicitudMonto;

    @Column(name = "solicitud_fecha")
    private Instant solicitudFecha;

    @NotNull
    @ManyToOne( optional = false)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuarios;

    @Size(max = 45)
    @Column(name = "solicitud_estado", length = 45)
    private String solicitudEstado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSolicitudProducto() {
        return solicitudProducto;
    }

    public void setSolicitudProducto(String solicitudProducto) {
        this.solicitudProducto = solicitudProducto;
    }

    public Double getSolicitudMonto() {
        return solicitudMonto;
    }

    public void setSolicitudMonto(Double solicitudMonto) {
        this.solicitudMonto = solicitudMonto;
    }

    public Instant getSolicitudFecha() {
        return solicitudFecha;
    }

    public void setSolicitudFecha(Instant solicitudFecha) {
        this.solicitudFecha = solicitudFecha;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public String getSolicitudEstado() {
        return solicitudEstado;
    }

    public void setSolicitudEstado(String solicitudEstado) {
        this.solicitudEstado = solicitudEstado;
    }

}