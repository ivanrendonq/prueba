package com.viamatica.prueba.dominio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viamatica.prueba.dominio.Usuario;
import com.viamatica.prueba.persistencia.crud.UsuarioRepositorio;
import com.viamatica.prueba.persistencia.entidades.UsuariosEntidad;
import com.viamatica.prueba.persistencia.mapeadores.UsuarioMapeador;

@Service
public class UsuariosServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    UsuarioMapeador usuarioMapeador;

    public List<Usuario> obtenerTodos()
    {
        return usuarioMapeador.toListaUsuarios( usuarioRepositorio.findAll());
    }

    public Optional<Usuario> obtenerPorId(Integer id)
    {
        return Optional.of( 
            usuarioMapeador.toUsuario( 
                usuarioRepositorio.findById(id).get()
            )
        );
    }

    public Optional<Usuario> obtenerPorNombreUsuario(String nombreUsuario)
    {
        return Optional.of(
            usuarioMapeador.toUsuario(
                usuarioRepositorio.findByUserName(nombreUsuario).get()
            )
        );
    }

    public Optional<Usuario> obtenerPorCorreo(String correo)
    {
        return Optional.of(
            usuarioMapeador.toUsuario(
                usuarioRepositorio.findByMail(correo).get()
            )
        );
    }

    public boolean borrar(Integer id)
    {
        try {
            Optional<UsuariosEntidad> usuarioOptional = usuarioRepositorio.findById(id);
            if (usuarioOptional.isPresent()) {
                UsuariosEntidad usuario = usuarioOptional.get();
                usuario.setEliminado("S");
                usuarioRepositorio.save(usuario);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        
    }

    public Usuario guardar(Usuario usuario) {
        Optional<UsuariosEntidad> usuarioOptional = usuarioRepositorio.findByUserName(usuario.getUserName());
        if (!usuarioOptional.isPresent()) {
            UsuariosEntidad usuariosEntidad = usuarioMapeador.toUsuariosEntidad(usuario);
            usuariosEntidad.setSessionActive("N");
            return usuarioMapeador.toUsuario(usuarioRepositorio.save(usuariosEntidad));
        } else {
            throw new RuntimeException("Usuario ya creado");
        }
    }

    public Usuario actualizar(Usuario usuario)
    {
        try {
            Optional<UsuariosEntidad> usuarioOptional = usuarioRepositorio.findById(usuario.getIdUsuarios());
            if (usuarioOptional.isPresent()) {
                usuario.setUserName(usuario.getUserName());
                usuario.setPassword(usuario.getPassword());
                return usuarioMapeador.toUsuario(
                    usuarioRepositorio.save(
                        usuarioMapeador.toUsuariosEntidad(usuario))
                );
            } else {
                return usuario;
            }
        } catch (Exception e) {
            return usuario;
        }
    }


}
