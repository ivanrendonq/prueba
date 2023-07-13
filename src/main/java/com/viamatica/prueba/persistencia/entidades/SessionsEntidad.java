package com.viamatica.prueba.persistencia.entidades;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Sessions")
@Data
public class SessionsEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSessions")
    Integer idSessions;

    @Column(name = "FechaIngreso")
    LocalDate fechaIngreso;

    @Column(name = "FechaCierre")
    LocalDate fechaCierre;

    @JoinColumn(name = "Usuarios_IdUsuario")
    @ManyToOne
    UsuariosEntidad usuarios_IdUsuario;

}
