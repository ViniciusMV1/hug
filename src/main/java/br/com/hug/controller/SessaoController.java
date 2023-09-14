package br.com.hug.controller;
import br.com.hug.models.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sessoes")

public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping

    public ResponseEntity criar(@RequestBody @Valid SessaoRecord sessao, UriComponentsBuilder uriBuilder) {
        var sessao = sessaoService.criar(form.converter());
        var uri = uriBuilder.path("/sessoes/{cpf}").buildAndExpand(sessaoCadastrada.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoSessaoRecord (sessaoCadastrada));
    }

    @GetMapping
     public ResponseEntity buscarTodos(@PageableDefault(size = 5, sort = {"paciente"}) Pageable pageable) {
        var sessoes = sessaoService.buscarTodos(pageable);
        return ResponseEntity.ok(sessoes.map(SessaoRecord::new)); }

    @GetMapping("/{cpf}")
    public ResponseEntity buscarPorId(@PathVariable Long cpf) {
        var sessao = sessaoService.buscarPorId(cpf);
        if(sessao == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhamentoSessaoRecord(sessao));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletar(@PathVariable Long cpf) {
        if(!sessaoService.existeSessao(cpf)) return ResponseEntity.notFound().build();
        sessaoService.deletar(cpf);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity atualizar(@PathVariable Long cpf, @RequestBody @Valid SessaoRecord sessaoAtualizada) {
        if(!sessaoService.existeSessao(cpf)) return ResponseEntity.notFound().build();
        var sessaoAtual = sessaoService.atualizar(cpf, sessaoAtualizada.converter());
        return ResponseEntity.ok(new DetalhamentoSessaoRecord(sessaoAtual));
    }


}
