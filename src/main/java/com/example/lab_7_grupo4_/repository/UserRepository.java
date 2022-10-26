package com.example.lab_7_grupo4_.repository;

import com.example.lab_7_grupo4_.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Integer> {
}
