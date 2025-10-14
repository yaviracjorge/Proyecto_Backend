package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
}
