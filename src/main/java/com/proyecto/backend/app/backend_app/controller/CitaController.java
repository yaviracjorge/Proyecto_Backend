package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.Cita;
import com.proyecto.backend.app.backend_app.servicies.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;
    public List<Cita> list(){
        return citaService.findAll();
    }
}
