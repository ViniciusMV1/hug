package br.com.hug.services;

import br.com.hug.models.Psicologo;
import br.com.hug.repositories.PsicologoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PsicologoService {

    private final PsicologoRepository psicologoRepository;
    private final PsicologoRepository psicologo;

    @Autowired
    public PsicologoService(PsicologoRepository psicologoRepository, PsicologoRepository psicologo) {
        this.psicologoRepository = psicologoRepository;
        this.psicologo = psicologo;

        }
    }

    @Transactional
    public Psicologo criar(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    public Psicologo buscar(String crp){
        return psicologoRepository.getById(crp);
    }

    public void deletar(String crp){
        psicologoRepository.deleteById(crp);
    }

    public List<Psicologo> buscarTodos(){
        return psicologoRepository.findAll();
    }

    public Psicologo atualizar (String crp, Psicologo psicologo) {

    var psicologo1 = psicologoRepository.findById(crp);
    psicologo1.get().setCrp(psicologo.getCrp());
    psicologo1.get().setNome(psicologo.getNome());
    psicologo1.get().setEndereco(psicologo.getEndereco());
    psicologo1.get().setTelefone(psicologo.getTelefone());
    return psicologoRepository.save(psicologo1.get());
}
}
