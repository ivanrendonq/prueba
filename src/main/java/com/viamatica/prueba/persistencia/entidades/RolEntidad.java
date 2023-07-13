package com.viamatica.prueba.persistencia.entidades;



import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Rol")
@Data
public class RolEntidad {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    Integer idRol;

    @Column(name = "RolName")
    String rolName;

    @OneToMany(mappedBy = "rol_IdRol")
    Set<RolUsuariosEntidad> rolUsuariosEntidadLista;
    
}
