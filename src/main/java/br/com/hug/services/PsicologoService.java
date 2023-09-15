package br.com.hug.services;

import br.com.hug.models.psicologo.Psicologo;
import br.com.hug.repositories.PsicologoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

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
        //
        var psicologo1 = psicologoRepository.findById(crp);
        if(psicologo1.isPresent()) {
            if (psicologo.getNome() != null) {
                psicologo1.get().setNome(psicologo.getNome());
            }
            if (psicologo.getCrp() != null) {
                psicologo1.get().setCrp(psicologo.getCrp());

            }
            if (psicologo.getEndereco() !=null) {
                psicologo1.get().setEndereco(psicologo.getEndereco());

            }
            if (psicologo.getTelefone() != null) {
                psicologo1.get().setTelefone(psicologo.getTelefone());

            }
            return psicologoRepository.save(psicologo1.get());
        }


        return null;
    }
}
