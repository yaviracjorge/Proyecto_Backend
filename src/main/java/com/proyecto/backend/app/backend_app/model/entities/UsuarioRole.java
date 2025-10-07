package com.proyecto.backend.app.backend_app.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class UsuarioRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UsuarioId")//nombre de la columna en esta tabla
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "RolId")
    private Rol rol;
}
