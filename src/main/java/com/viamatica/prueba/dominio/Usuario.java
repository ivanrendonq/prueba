package com.viamatica.prueba.dominio;

import java.util.List;

import lombok.Data;

@Data
public class Usuario {
    private Integer idUsuarios;
    private String userName;
    private String password;
    private String mail;
    private Integer persona_IdPersona;
    private String sessionActive;
    private String status;
    private String eliminado;
    private List<RolUsuario> roles;
}
