package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.Rol;
import com.proyecto.backend.app.backend_app.servicies.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;
    public List<Rol> list(){
        return rolService.findAll();
    }
}
