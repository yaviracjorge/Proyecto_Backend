package com.proyecto.backend.app.backend_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.backend.app.backend_app.model.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

}
