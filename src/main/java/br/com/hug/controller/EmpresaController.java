package br.com.hug.controller;

import br.com.hug.models.empresa.EmpresaResponse;
import br.com.hug.models.empresa.EmpresaRecord;
import br.com.hug.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid EmpresaRecord empresa, UriComponentsBuilder builder) {
        var aux = empresa.toEmpresa();
        aux = empresaService.criar(aux);
        var uri = builder.path("/empresa/{cnpj}").buildAndExpand(aux.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity buscar(@PathVariable String cnpj) {
        var aux = empresaService.buscar(cnpj);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable String cnpj) {
        empresaService.deletar(cnpj);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity atualizar(@PathVariable String cnpj, @RequestBody @Valid EmpresaRecord empresa) {
        if (!empresaService.existeEmpresa(cnpj)) {
            return ResponseEntity.notFound().build();
        }
        var empresa1 = empresaService.atualizar(cnpj, empresa.toEmpresa());
        return ResponseEntity.ok(new EmpresaResponse(empresa1));

    }

    //TODO: Implementar o método de busca todos

    @GetMapping()
    public ResponseEntity buscarTodos() {
        var empresas = empresaService.buscarTodos();
        return ResponseEntity.ok(empresas.stream().map(EmpresaResponse::new));

    }

}