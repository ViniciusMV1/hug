package br.com.hug.models;

import br.com.hug.models.empresa.Empresa;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Paciente extends Pessoa{

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Paciente(String cpf, String nome, String email, String telefone, Endereco endereco, Empresa empresa) {
        super(cpf, nome, email, telefone, endereco);
        this.empresa = empresa;
    }

    public Paciente() {

    }
}
