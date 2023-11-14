package br.com.hug.models.empresa;

import br.com.hug.models.Endereco;


public record EmpresaResponse(

        String cnpj,
        String nome,
        Endereco endereco,
        String telefone) {
    public EmpresaResponse (Empresa empresa){
        this(empresa.getCnpj(), empresa.getNome(), empresa.getEndereco(), empresa.getTelefone());
    }
}
