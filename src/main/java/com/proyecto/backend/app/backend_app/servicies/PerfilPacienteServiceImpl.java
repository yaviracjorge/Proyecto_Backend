package com.proyecto.backend.app.backend_app.servicies;


import com.proyecto.backend.app.backend_app.model.entities.PerfilPaciente;
import com.proyecto.backend.app.backend_app.repositories.PerfilPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilPacienteServiceImpl implements PerfilPacienteService {
    @Autowired
    private PerfilPacienteRepository perfilPacienteRepository;

    @Override
    @Transactional
    public List<PerfilPaciente> findAll() {
        return(List<PerfilPaciente>)perfilPacienteRepository.findAll();
    }
}
