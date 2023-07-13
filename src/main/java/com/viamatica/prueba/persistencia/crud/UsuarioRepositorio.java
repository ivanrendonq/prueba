package com.viamatica.prueba.persistencia.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.viamatica.prueba.persistencia.entidades.UsuariosEntidad;

import jakarta.transaction.Transactional;

import java.util.Optional;


public interface UsuarioRepositorio extends JpaRepository<UsuariosEntidad, Integer>{
    Optional<UsuariosEntidad> findByUserName(String userName);
    Optional<UsuariosEntidad> findByMail(String mail);

    @Modifying
    @Transactional
    @Query("UPDATE UsuariosEntidad u SET u.eliminado = 'S' WHERE u.id = :id")
    void marcarComoEliminado(Integer id);
}
