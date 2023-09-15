package br.com.hug.services;

import br.com.hug.models.paciente.Paciente;
import br.com.hug.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public Paciente criar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscar(String cpf){
        return pacienteRepository.getById(cpf);
    }

    public void deletar(String cpf){
        pacienteRepository.deleteById(cpf);
    }

    public List<Paciente> buscarTodos(){
        return pacienteRepository.findAll();
    }
}

