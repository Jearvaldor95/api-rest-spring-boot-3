package com.tutorial.apirest.repository;

import com.tutorial.apirest.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Boolean existsByNombre(String nombre);

    List<Producto> findByCategoria(String categoria);
}
