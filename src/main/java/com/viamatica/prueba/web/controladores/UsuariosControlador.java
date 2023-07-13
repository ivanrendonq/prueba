package com.viamatica.prueba.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viamatica.prueba.dominio.Usuario;
import com.viamatica.prueba.dominio.servicio.UsuariosServicio;
import com.viamatica.prueba.persistencia.Validadores.JsonSchemaValidador;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControlador {
    
    @Autowired
    UsuariosServicio usuariosServicio;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodos()
    {
        try {
            List<Usuario> usuarios = usuariosServicio.obtenerTodos();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario)
    {
        try {
            JsonSchemaValidador validador = new JsonSchemaValidador();
            ObjectMapper objectMapper = new ObjectMapper();
            String usuarioJson = objectMapper.writeValueAsString(usuario);
            // if(validador.validateData(usuarioJson, "src/main/resources/usuarioJsonSchema.json"))
            // {
                
                return new ResponseEntity<Usuario>(usuariosServicio.guardar(usuario),HttpStatus.CREATED);
            // }

            // return new ResponseEntity<Usuario>(usuario, HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }


    @DeleteMapping
    public ResponseEntity<Usuario> borrar(@RequestBody Usuario usuario)
    {
        try {
            usuariosServicio.borrar(usuario.getIdUsuarios());
            return new ResponseEntity<Usuario>(usuario,HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuario)
    {
        try {
            usuariosServicio.actualizar(usuario);
            return new ResponseEntity<Usuario>(usuario,HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
