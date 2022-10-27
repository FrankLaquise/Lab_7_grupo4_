package com.example.lab_7_grupo4_.repository;

import com.example.lab_7_grupo4_.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
}