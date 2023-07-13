package com.viamatica.prueba.persistencia.mapeadores;

import com.viamatica.prueba.dominio.RolUsuario;
import com.viamatica.prueba.dominio.Usuario;
import com.viamatica.prueba.persistencia.entidades.RolUsuariosEntidad;
import com.viamatica.prueba.persistencia.entidades.UsuariosEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-12T22:05:30-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230629-1618, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapeadorImpl implements UsuarioMapeador {

    @Override
    public Usuario toUsuario(UsuariosEntidad entidad) {
        if ( entidad == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setIdUsuarios( entidad.getIdUsuario() );
        usuario.setUserName( entidad.getUserName() );
        usuario.setPassword( entidad.getPassword() );
        usuario.setMail( entidad.getMail() );
        usuario.setPersona_IdPersona( entidad.getPersona_IdPersona() );
        usuario.setStatus( entidad.getStatus() );
        usuario.setEliminado( entidad.getEliminado() );
        usuario.setRoles( rolUsuariosEntidadListToRolUsuarioList( entidad.getRolUsuariosEntidadLista() ) );

        return usuario;
    }

    @Override
    public List<Usuario> toListaUsuarios(List<UsuariosEntidad> listaUsuariosEntidad) {
        if ( listaUsuariosEntidad == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( listaUsuariosEntidad.size() );
        for ( UsuariosEntidad usuariosEntidad : listaUsuariosEntidad ) {
            list.add( toUsuario( usuariosEntidad ) );
        }

        return list;
    }

    @Override
    public UsuariosEntidad toUsuariosEntidad(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuariosEntidad usuariosEntidad = new UsuariosEntidad();

        usuariosEntidad.setIdUsuario( usuario.getIdUsuarios() );
        usuariosEntidad.setUserName( usuario.getUserName() );
        usuariosEntidad.setPassword( usuario.getPassword() );
        usuariosEntidad.setMail( usuario.getMail() );
        usuariosEntidad.setPersona_IdPersona( usuario.getPersona_IdPersona() );
        usuariosEntidad.setStatus( usuario.getStatus() );
        usuariosEntidad.setEliminado( usuario.getEliminado() );
        usuariosEntidad.setRolUsuariosEntidadLista( rolUsuarioListToRolUsuariosEntidadList( usuario.getRoles() ) );

        return usuariosEntidad;
    }

    protected RolUsuario rolUsuariosEntidadToRolUsuario(RolUsuariosEntidad rolUsuariosEntidad) {
        if ( rolUsuariosEntidad == null ) {
            return null;
        }

        RolUsuario rolUsuario = new RolUsuario();

        return rolUsuario;
    }

    protected List<RolUsuario> rolUsuariosEntidadListToRolUsuarioList(List<RolUsuariosEntidad> list) {
        if ( list == null ) {
            return null;
        }

        List<RolUsuario> list1 = new ArrayList<RolUsuario>( list.size() );
        for ( RolUsuariosEntidad rolUsuariosEntidad : list ) {
            list1.add( rolUsuariosEntidadToRolUsuario( rolUsuariosEntidad ) );
        }

        return list1;
    }

    protected RolUsuariosEntidad rolUsuarioToRolUsuariosEntidad(RolUsuario rolUsuario) {
        if ( rolUsuario == null ) {
            return null;
        }

        RolUsuariosEntidad rolUsuariosEntidad = new RolUsuariosEntidad();

        return rolUsuariosEntidad;
    }

    protected List<RolUsuariosEntidad> rolUsuarioListToRolUsuariosEntidadList(List<RolUsuario> list) {
        if ( list == null ) {
            return null;
        }

        List<RolUsuariosEntidad> list1 = new ArrayList<RolUsuariosEntidad>( list.size() );
        for ( RolUsuario rolUsuario : list ) {
            list1.add( rolUsuarioToRolUsuariosEntidad( rolUsuario ) );
        }

        return list1;
    }
}
