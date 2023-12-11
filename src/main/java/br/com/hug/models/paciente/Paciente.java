package br.com.hug.models.paciente;

import br.com.hug.models.Endereco;
import br.com.hug.models.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Paciente{

    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    public Paciente(String cpf, String nome, String email, String telefone, Endereco endereco, Empresa empresa) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.empresa = empresa;
    }

}


