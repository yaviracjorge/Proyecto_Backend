package com.proyecto.backend.app.backend_app.model.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Timer;

@Entity

public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Temporal(TemporalType.DATE)
    private Date Fecha;
    @Temporal(TemporalType.TIME)
    private Date Hora;

    @ManyToOne
    @JoinColumn(name = "PerfilPacienteId")
    private PerfilPaciente PerfilPaciente;

    @ManyToOne
    @JoinColumn(name = "PerfilClinicaId")
    private PerfilClinica PerfilClinica;


}
