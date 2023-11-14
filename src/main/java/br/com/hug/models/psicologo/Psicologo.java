package br.com.hug.models.psicologo;

import br.com.hug.models.Endereco;
import br.com.hug.models.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Psicologo extends Pessoa {
    private String crp;

    public Psicologo(String cpf, String nome,String email, String telefone, Endereco endereco, String crp) {
        super(cpf, nome, email, telefone, endereco);
        this.crp = crp;
    }

    /*public Psicologo(@NotNull @NotBlank @Size(min = 12, max = 12) @Pattern(regexp = "\\d{12}") String crp, @NotNull @NotBlank @Size(max = 100) String nome, @NotNull @NotBlank @Email @Size(max = 100) String email, @NotNull Endereco endereco, @NotNull @NotBlank @Size(max = 20) String telefone) {

    }*/

    public Psicologo() {

    }
}
