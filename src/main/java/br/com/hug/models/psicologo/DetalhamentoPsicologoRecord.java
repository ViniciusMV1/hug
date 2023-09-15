package br.com.hug.models.psicologo;
import br.com.hug.models.Endereco;

public record DetalhamentoPsicologoRecord(String crp, String nome, String email, String telefone, Endereco endereco) {
    public DetalhamentoPsicologoRecord (Psicologo psicologo) {
        this(psicologo.getCrp(), psicologo.getNome(), psicologo.getEmail(), psicologo.getTelefone(), psicologo.getEndereco());
    }
}
