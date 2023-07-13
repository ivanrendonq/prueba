package com.viamatica.prueba.persistencia.entidades;



import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class UsuariosEntidad {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    Integer idUsuario;

    @Column(name = "UserName")
    String userName;

    @Column(name = "Password")
    String password;

    @Column(name = "Mail")
    String mail;

    @Column(name = "Persona_IdPersona")
    Integer persona_IdPersona;
    
    @Column(name = "Status")
    String status;

    @Column(name = "SessionActive")
    String sessionActive;

    @Column(name = "Eliminado")
    String eliminado;

    @Column(name = "FechaEliminacion")
    LocalDate fechaEliminacion;

    @ManyToOne
    @JoinColumn(name = "persona_IdPersona", insertable = false, updatable = false)
    private PersonaEntidad personaEntidad;

    // @OneToMany(mappedBy = "usuarios_IdUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // private List<RolUsuariosEntidad> rolUsuariosEntidadLista;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Rol_Usuarios",
        joinColumns = @JoinColumn(name = "Usuarios_IdUsuario"),
        inverseJoinColumns = @JoinColumn(name = "Rol_IdRol")
    )
    private List<RolUsuariosEntidad> rolUsuariosEntidadLista;
}
