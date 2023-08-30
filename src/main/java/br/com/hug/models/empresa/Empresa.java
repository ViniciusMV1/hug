package br.com.hug.models.empresa;

import br.com.hug.models.Embedded;
import br.com.hug.models.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    private String cnpj;
    private String nome;
    @Embedded
    private Endereco endereco;
    private String telefone;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

