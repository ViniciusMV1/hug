package br.com.hug.models.nota;

import br.com.hug.models.paciente.Paciente;

public record NotaRecord(Long id, String texto, Paciente paciente) {
    public Nota converter() {
        return new Nota(id(), texto(), paciente());
    }
}
