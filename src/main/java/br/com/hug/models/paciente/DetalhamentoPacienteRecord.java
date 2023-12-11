package br.com.hug.models.paciente;

import br.com.hug.models.Endereco;

public record DetalhamentoPacienteRecord(String cpf, String nome, String email, String telefone, Endereco endereco) {
    public DetalhamentoPacienteRecord(Paciente paciente) {
        this(paciente.getCpf(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }


}
