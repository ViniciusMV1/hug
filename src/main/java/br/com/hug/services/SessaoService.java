package br.com.hug.services;

import br.com.hug.models.Sessao;
import br.com.hug.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public Sessao criar(Sessao sessao) {
        return sessaoRepository.save(sessao);
    }

    public Sessao buscarPorId(Long id) {
        return sessaoRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
    }

    public List<Sessao> buscarTodos() {
        return sessaoRepository.findAll();
    }

    public void deletar(Long cpf) {
        sessaoRepository.deleteById(cpf);
    }

    public Sessao atualizar(Long cpf, Sessao sessaoAtualizada) {
        Sessao sessaoAtual = (Sessao) sessaoRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        sessaoAtual.setCpf(sessaoAtualizada.getCpf());
        sessaoAtual.setData(sessaoAtualizada.getData());
        sessaoAtual.setNota(sessaoAtualizada.getNota());
        sessaoAtual.setPaciente(sessaoAtualizada.getPaciente());
        sessaoAtual.setPsicologo(sessaoAtualizada.getPsicologo());

        return sessaoRepository.save(sessaoAtual);
    }

    public boolean existeSessao(Long cpf) {
        return sessaoRepository.existsById(cpf);
    }
}
