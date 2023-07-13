package com.viamatica.prueba.dominio.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viamatica.prueba.persistencia.crud.UsuarioRepositorio;
import com.viamatica.prueba.persistencia.entidades.UsuariosEntidad;

@Service
public class SeguridadUsuarioServicio implements UserDetailsService{
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuariosEntidad usuariosEntidad = usuarioRepositorio.findByUserName(username).orElseThrow(
            () -> new UsernameNotFoundException(username)
        );


        List<String> roles = usuariosEntidad.getRolUsuariosEntidadLista().stream().map(
            rolUsuario -> rolUsuario.getRol_IdRol().getRolName()
        ).collect(Collectors.toList());

        
        return User.builder().
            username(usuariosEntidad.getUserName()).
            username(usuariosEntidad.getMail()).
            password(usuariosEntidad.getPassword()).
            roles( String.join(",", roles)).
            build();
    }


}
