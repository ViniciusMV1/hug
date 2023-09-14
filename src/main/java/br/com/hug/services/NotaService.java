package br.com.hug.services;

import br.com.hug.models.Nota;
import br.com.hug.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public Nota criar(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota buscarPorId(Long cpf) {
        Optional<Nota> notaOptional = notaRepository.findById(cpf);
        return notaOptional.orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    }

    public List<Nota> buscarTodos() {
        return notaRepository.findAll();
    }

    public void deletar(Long cpf) {
        notaRepository.deleteById(cpf);
    }

    public Nota atualizar(Long cpf, Nota notaAtualizada) {
        Optional<Nota> notaOptional = notaRepository.findById(cpf);
        Nota notaAtual = notaOptional.orElseThrow(() -> new RuntimeException("Nota não encontrada"));

        notaAtual.setNota(notaAtualizada.getNota());

        return notaRepository.save(notaAtual);
    }

    public boolean existeNota(Long cpf) {
        return notaRepository.existsById(cpf);
    }

    public Page<Nota> buscarTodos(Pageable pageable) {
        return notaRepository.findAll(pageable);
    }
}


