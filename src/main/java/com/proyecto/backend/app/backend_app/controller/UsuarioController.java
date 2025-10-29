package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.Usuario;
import com.proyecto.backend.app.backend_app.servicies.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:8100")
public class UsuarioController {
    @Autowired

    private UsuarioService usuarioService;
    @GetMapping
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

     @PostMapping
     public Usuario save(@RequestBody Usuario usuario){
         return usuarioService.save(usuario);
     }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Usuario usuario){
        Optional<Usuario> userOptional = usuarioService.update(id, usuario);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
    }



}
