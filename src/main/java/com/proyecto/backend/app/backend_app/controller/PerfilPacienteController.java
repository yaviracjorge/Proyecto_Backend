package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.PerfilClinica;
import com.proyecto.backend.app.backend_app.servicies.PerfilClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/perfilPaciente")
public class PerfilPacienteController {
    @Autowired
    private PerfilClinicaService perfilClinicaService;
    public List<PerfilClinica> list(){
        return perfilClinicaService.findAll();
    }
}
