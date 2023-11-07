package br.com.hug.services;

import br.com.hug.models.nota.Nota;
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

    public Nota buscarPorId(Long id) {
        Optional<Nota> notaOptional = notaRepository.findById(id);
        return notaOptional.orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    }

    public void deletar(Long id) {
        notaRepository.deleteById(id);
    }

    public Nota atualizar(Long id, Nota notaAtualizada) {
        Optional<Nota> notaOptional = notaRepository.findById(id);
        Nota notaAtual = notaOptional.orElseThrow(() -> new RuntimeException("Nota não encontrada"));

        notaAtual.setTexto(notaAtualizada.getTexto());

        return notaRepository.save(notaAtual);
    }

    public boolean existeNota(Long id) {
        return notaRepository.existsById(id);
    }

    public Page<Nota> buscarTodos(Pageable pageable) {
        return notaRepository.findAll(pageable);
    }
}


