package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.Especialidad;
import com.proyecto.backend.app.backend_app.servicies.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    public List<Especialidad> list(){
        return especialidadService.findAll();
    }
}
