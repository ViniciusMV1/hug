package br.com.hug.models.empresa;

import br.com.hug.models.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmpresaRecord {
    public record FuncionarioRecord (
            @NotNull
            @NotBlank
            @Size(min = 14, max = 14)
            @Pattern(regexp = "\\d{14}")
            String cnpj,

            @NotNull
            @NotBlank
            @Size(max = 100)
            String nome,

            @NotNull
            Endereco endereco,

            @NotNull
            @NotBlank
            @Size(max = 20)
            String telefone)
    {
        public Empresa toEmpresa() {
            return new Empresa (cnpj(), nome(), endereco(), telefone());
        }
    }
}