package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.Especialidad;
import com.proyecto.backend.app.backend_app.repositories.EspecialidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Override
    @Transactional
    public List<Especialidad> findAll(){
        return (List<Especialidad>) especialidadRepository.findAll();
    }
}
