package br.com.hug.models.sessao;

import br.com.hug.models.paciente.Paciente;
import br.com.hug.models.psicologo.Psicologo;
import br.com.hug.models.nota.Nota;

import java.time.LocalDateTime;

public record SessaoRecord(Long id,Paciente paciente, Psicologo psicologo, LocalDateTime data, Nota nota) {
    public Sessao converter() {
        return new Sessao(id(), paciente(), psicologo(), data(),nota());
    }
}
