package br.com.hug.models.psicologo;

import br.com.hug.models.Endereco;
import br.com.hug.models.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Psicologo extends Pessoa {
    private String crp;

    public Psicologo(String cpf, String nome, String telefone, Endereco endereco, String crp) {
        super(cpf, nome, email, telefone, endereco);
        this.crp = crp;
    }

    public Psicologo() {

    }
}
