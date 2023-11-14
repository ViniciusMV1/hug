package br.com.hug.models.psicologo;

import br.com.hug.models.Endereco;
import br.com.hug.models.psicologo.Psicologo;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public record PsicologoRecord(

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
        Endereco endereco,

        @NotNull
        @NotBlank
        @Size(max = 20)
        String telefone,
        @NotNull
        @NotBlank
        @Size(min = 12, max = 12)
        @Pattern(regexp = "\\d{12}")
        String crp
) {
    public Psicologo converter() {
        return new Psicologo(cpf(), nome(), email(), telefone(), endereco(), crp());
    }

}
