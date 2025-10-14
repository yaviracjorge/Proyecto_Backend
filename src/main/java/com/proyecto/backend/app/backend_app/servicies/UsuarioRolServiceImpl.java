package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.UsuarioRole;
import com.proyecto.backend.app.backend_app.repositories.UsuarioRolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    @Override
    @Transactional
    public List<UsuarioRole> findAll() {
        return (List<UsuarioRole>)usuarioRolRepository.findAll();
    }
}
