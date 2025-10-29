package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario user);
    void deleteById(Long id);
    Optional<Usuario> update(Long id, Usuario user);


}
