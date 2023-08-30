package br.com.hug.models.empresa;

import br.com.hug.models.Endereco;

public record EmpresaAtualizarRecord (
        String cnpj,
        String nome,
        Endereco endereco,
        String telefone){
}