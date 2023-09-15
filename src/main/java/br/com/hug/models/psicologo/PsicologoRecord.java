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
        @Size(min = 12, max = 12)
        @Pattern(regexp = "\\d{12}")
        String crp,

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
        String telefone
) {
    public Psicologo converter() {
        return new Psicologo(crp(), nome(), email(), endereco(), telefone());
    }

}
