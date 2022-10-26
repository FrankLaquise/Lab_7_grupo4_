package com.example.lab_7_grupo4_.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "desembolsos")
public class Desembolso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "monto_desembolso", length = 45)
    private String montoDesembolso;

    @Column(name = "fecha")
    private Instant fecha;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creditos_id", nullable = false)
    private Credito creditos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMontoDesembolso() {
        return montoDesembolso;
    }

    public void setMontoDesembolso(String montoDesembolso) {
        this.montoDesembolso = montoDesembolso;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Credito getCreditos() {
        return creditos;
    }

    public void setCreditos(Credito creditos) {
        this.creditos = creditos;
    }

}