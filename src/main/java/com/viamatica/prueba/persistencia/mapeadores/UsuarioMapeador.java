package com.viamatica.prueba.persistencia.mapeadores;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.viamatica.prueba.dominio.Usuario;
import com.viamatica.prueba.persistencia.entidades.UsuariosEntidad;

@Mapper(componentModel = "spring")

public interface UsuarioMapeador {

    @Mappings({
        @Mapping(source = "idUsuario", target = "idUsuarios"),
        @Mapping(source = "userName", target = "userName"),
        @Mapping(source = "password", target = "password"),
        @Mapping(source = "mail", target = "mail"),
        @Mapping(source = "persona_IdPersona", target = "persona_IdPersona"),
        @Mapping(source = "status", target = "status"),
        @Mapping(source = "eliminado", target = "eliminado"),
        @Mapping(source = "rolUsuariosEntidadLista", target = "roles")
    })
    Usuario toUsuario(UsuariosEntidad entidad);

    List<Usuario> toListaUsuarios(List<UsuariosEntidad> listaUsuariosEntidad);

    

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "personaEntidad", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true)
    })
    UsuariosEntidad toUsuariosEntidad(Usuario usuario);

}
