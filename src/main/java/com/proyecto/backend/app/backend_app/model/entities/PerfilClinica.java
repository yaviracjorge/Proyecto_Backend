package com.proyecto.backend.app.backend_app.model.entities;
import jakarta.persistence.*;

@Entity

public class PerfilClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private boolean Disponible;
    @ManyToOne
    @JoinColumn(name = "UsuarioId")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "EspecialidadId")
    private Especialidad especialidad;

}
