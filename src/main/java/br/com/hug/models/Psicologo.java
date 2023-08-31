package br.com.hug.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Psicologo extends  Pessoa{
    private String crp;

    public Psicologo(String cpf, String nome, String email, String telefone, Endereco endereco, String crp) {
        super(cpf, nome, email, telefone, endereco);
        this.crp = crp;
    }

    public Psicologo() {

    }
}
