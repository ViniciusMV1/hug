package br.com.hug.services;

import br.com.hug.models.Paciente;
import br.com.hug.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criar (Paciente) {

    }
}
