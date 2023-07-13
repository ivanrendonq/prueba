package com.viamatica.prueba.persistencia.entidades;



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
@Table(name = "Rol_RolOpciones")
@Data
public class RolRolOpciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol_RolOpciones")
    Integer idRol_RolOpciones;

    @JoinColumn(name = "Rol_IdRol")
    @ManyToOne
    RolEntidad rol_IdRol;

    @JoinColumn(name = "RolOpciones_IdOpcion")
    @ManyToOne
    RolOpcionesEntidad rolOpciones_IdOpcion;

}
