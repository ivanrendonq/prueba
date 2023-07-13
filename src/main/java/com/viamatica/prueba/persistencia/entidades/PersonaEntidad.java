package com.viamatica.prueba.persistencia.entidades;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Persona")
@Data
public class PersonaEntidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPersona")
    Integer idPersona;

    @Column(name= "Nombres")
    String nombres;

    @Column(name = "Apellidos")
    String apellidos;

    @Column(name = "Identificacion")
    String identificacion;

    @Column(name = "FechaNacimiento")
    LocalDate fechaNacimiento;

    @Column(name = "Eliminado")
    char eliminado;

    @Column(name = "FechaEliminacion")
    LocalDate fechaEliminacion;

}
