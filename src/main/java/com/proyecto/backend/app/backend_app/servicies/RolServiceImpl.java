package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.Rol;
import com.proyecto.backend.app.backend_app.repositories.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional
    public List<Rol> findAll() {
        return (List<Rol>)rolRepository.findAll();
    }
}
