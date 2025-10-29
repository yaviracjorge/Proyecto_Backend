package com.proyecto.backend.app.backend_app.model.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity

public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Temporal(TemporalType.DATE)
    private Date Fecha;
    @Temporal(TemporalType.TIME)
    private Date Hora;

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Date getHora() {
        return Hora;
    }

    public void setHora(Date hora) {
        Hora = hora;
    }



}
