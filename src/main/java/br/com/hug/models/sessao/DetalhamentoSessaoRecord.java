package br.com.hug.models.sessao;

import br.com.hug.models.paciente.Paciente;
import br.com.hug.models.psicologo.Psicologo;
import br.com.hug.models.nota.Nota;

import java.time.LocalDateTime;

public record DetalhamentoSessaoRecord(Long id, Paciente paciente, Psicologo psicologo, LocalDateTime data, Nota nota) {
    public DetalhamentoSessaoRecord(Sessao sessao){
        this(sessao.getId(), sessao.getPaciente(), sessao.getPsicologo(), sessao.getData(), sessao.getNota());
    }

}
