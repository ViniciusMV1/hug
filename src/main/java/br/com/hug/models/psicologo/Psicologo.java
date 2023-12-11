package br.com.hug.models.psicologo;

import br.com.hug.models.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Psicologo{
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private String crp;





}
