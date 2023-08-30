package br.com.hug.models.empresa;

import br.com.hug.models.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empresa {
    @Id
    private String cnpj;
    private String nome;
    private Endereco endereco;
    private String telefone;

}

