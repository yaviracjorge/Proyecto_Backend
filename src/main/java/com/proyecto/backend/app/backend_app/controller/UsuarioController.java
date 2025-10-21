package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.Usuario;
import com.proyecto.backend.app.backend_app.servicies.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired

    private UsuarioService usuarioService;
    public List<Usuario> list(){
        return usuarioService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Usuario> userOptional = usuarioService.findById(id);
        if(userOptional.isPresent()){
            return  ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    /*public Usuario show(@PathVariable Long id){
        return usuarioService.findById(id).orElseThrow();
    }*/

    @DeleteMapping("/{id}")
    public void deleteById(Long id){
        usuarioService.deleteById(id);
    }


}
