package com.example.lab_7_grupo4_.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cuotas")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @Column(name = "monto")
    private Double monto;

    @NotNull
    @ManyToOne( optional = false)
    @JoinColumn(name = "creditos_id", nullable = false)
    private Credito creditos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Credito getCreditos() {
        return creditos;
    }

    public void setCreditos(Credito creditos) {
        this.creditos = creditos;
    }

}