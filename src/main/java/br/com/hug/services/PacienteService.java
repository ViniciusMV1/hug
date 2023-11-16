package br.com.hug.services;

import br.com.hug.models.empresa.Empresa;
import br.com.hug.models.paciente.Paciente;
import br.com.hug.models.paciente.PacienteRecord;
import br.com.hug.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    private ModelMapper modelMapper;

    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }


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

    public Paciente atualizar(String cpf, Paciente paciente) {
        var pacienteAux = pacienteRepository.findById(cpf);
        if(pacienteAux.isPresent()){
            modelMapper.map(paciente, pacienteAux.get());
            return pacienteRepository.save(pacienteAux.get());
        }
        throw new RuntimeException("Paciente não encontrado no banco de dados.");
    }


    public Paciente atualizar(PacienteRecord paciente) {
        var pacienteAux = pacienteRepository.findById(cpf);
        if(pacienteAux.isPresent()){
            modelMapper.map(paciente, pacienteAux.get());
            return pacienteRepository.save(pacienteAux.get());
        }
        throw new RuntimeException("Paciente não encontrado no banco de dados.");
    }

    public boolean existePaciente(String cpf) {
        return pacienteRepository.existsById(cpf);
    }
}

