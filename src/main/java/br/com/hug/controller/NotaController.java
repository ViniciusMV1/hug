package br.com.hug.controller;

import br.com.hug.models.nota.DetalhamentoNotaRecord;
import br.com.hug.models.nota.NotaRecord;
import br.com.hug.services.NotaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid NotaRecord nota, UriComponentsBuilder uriBuilder) {
        var notaCadastrada = notaService.criar(nota.converter());
        var uri = uriBuilder.path("/notas/{id}").buildAndExpand(notaCadastrada.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoNotaRecord(notaCadastrada));
    }

    @GetMapping
    public ResponseEntity buscarTodos(@PageableDefault Pageable pageable) {
        var notas = notaService.buscarTodos(pageable);
        return ResponseEntity.ok(notas.stream().map(DetalhamentoNotaRecord::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var nota = notaService.buscarPorId(id);
        if (nota == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DetalhamentoNotaRecord(nota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!notaService.existeNota(id)) {
            return ResponseEntity.notFound().build();
        }
        notaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")

    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid NotaRecord notaAtualizada) {
        if (!notaService.existeNota(id)) {
            return ResponseEntity.notFound().build();
        }
        var notaAtual = notaService.atualizar(id, notaAtualizada.converter());
        return ResponseEntity.ok(new DetalhamentoNotaRecord(notaAtual));
    }
}
