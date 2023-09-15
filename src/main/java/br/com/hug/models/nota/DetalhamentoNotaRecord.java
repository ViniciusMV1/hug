package br.com.hug.models.nota;

public record DetalhamentoNotaRecord(Long id, String texto) {
    public DetalhamentoNotaRecord(Nota nota){
        this(nota.getId(), nota.getTexto());
    }
}
