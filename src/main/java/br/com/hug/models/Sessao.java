package br.com.hug.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.security.PrivateKey;
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
