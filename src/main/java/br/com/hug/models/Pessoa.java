package br.com.hug.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;


}
