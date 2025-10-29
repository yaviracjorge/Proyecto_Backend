package com.proyecto.backend.app.backend_app.controller;

import com.proyecto.backend.app.backend_app.model.entities.UsuarioRole;
import com.proyecto.backend.app.backend_app.servicies.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuarioRole")
public class UsuarioRoleController {
    @Autowired
    private UsuarioRolService usuarioRolService;
    public List<UsuarioRole>list(){
        return usuarioRolService.findAll();
    }
}
