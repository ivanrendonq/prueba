package com.viamatica.prueba.persistencia.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viamatica.prueba.persistencia.entidades.RolEntidad;

public interface RolRepositorio extends JpaRepository<RolEntidad, Integer>{
    
}
