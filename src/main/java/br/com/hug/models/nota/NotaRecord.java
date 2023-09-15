package br.com.hug.models.nota;

public record NotaRecord(Long id, String texto) {
    public Nota converter() {
        return new Nota(id(), texto());
    }
}
