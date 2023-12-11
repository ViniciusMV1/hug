package br.com.hug.models.paciente;

import br.com.hug.models.Endereco;
import br.com.hug.models.paciente.Paciente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PacienteRecord(

        @NotNull
        @NotBlank
        @Size(min = 11, max = 11)
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotNull
        @NotBlank
        @Email
        @Size(max = 100)
        String email,

        @NotNull
        @NotBlank
        @Size(max = 20)
        String telefone,

        //@NotNull
        Endereco endereco) {

    public Paciente converter() {
        return new Paciente(cpf(), nome(), email(), telefone(), endereco(), null);
    }
}

