package br.com.hug.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;

@Entity
public class Sessao {

    @OneToOne
    public Paciente paciente;
    @OneToOne
    public Psicologo psicologo;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data;
    @OneToOne
    private Nota nota;

}
