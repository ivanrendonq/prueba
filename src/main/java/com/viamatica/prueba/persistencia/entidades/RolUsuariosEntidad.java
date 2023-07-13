package com.viamatica.prueba.persistencia.entidades;



import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Rol_Usuarios")
@Data
public class RolUsuariosEntidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol_Usuarios")
    Integer idRol_Usuarios;

    @JoinColumn(name = "Rol_IdRol")
    @ManyToOne
    RolEntidad rol_IdRol;

    // @JoinColumn(name =  "usuarios_IdUsuario", referencedColumnName = "IdUsuario")
    // @ManyToOne
    // UsuariosEntidad usuarios_IdUsuario;

    
    @ManyToMany(mappedBy = "rolUsuariosEntidadLista")
    Set<UsuariosEntidad> usuarios_IdUsuario;
}

