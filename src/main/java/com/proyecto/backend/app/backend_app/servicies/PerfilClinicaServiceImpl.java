package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.PerfilClinica;
import com.proyecto.backend.app.backend_app.repositories.PerfilClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilClinicaServiceImpl implements PerfilClinicaService {
    @Autowired
    private PerfilClinicaRepository perfilClinicaRepository;

    @Override
    @Transactional
    public List<PerfilClinica> findAll() {
        return (List<PerfilClinica>) perfilClinicaRepository.findAll();
    }




}
