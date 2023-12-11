package br.com.hug.controller;

import br.com.hug.models.empresa.EmpresaRecord;
import br.com.hug.models.empresa.EmpresaResponse;
import br.com.hug.models.paciente.Paciente;
import br.com.hug.models.paciente.PacienteRecord;
import br.com.hug.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid PacienteRecord paciente, UriComponentsBuilder builder){

        var p = pacienteService.criar(paciente.converter());
        var uri = builder.path("/paciente/{cpf}").buildAndExpand(p.getCpf()).toUri();
        return ResponseEntity.created(uri).body(p);
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        var pacientes = pacienteService.buscarTodos();
        return ResponseEntity.ok(pacientes);
    }

    @DeleteMapping("/{cpf}")
    public  ResponseEntity delete(@PathVariable String cpf){
        pacienteService.deletar(cpf);
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{cpf}")
    public ResponseEntity atualizar(@PathVariable String cpf, @RequestBody @Valid PacienteRecord paciente){
        if (!pacienteService.existePaciente(cpf)) {
            return ResponseEntity.notFound().build();
        }
        var paciente1 = pacienteService.atualizar(paciente);
        return ResponseEntity.ok(paciente1);
    }

    //TODO: Implementar o método de busca por cpf

    @GetMapping("/{cpf}")
    public ResponseEntity buscar(@PathVariable String cpf){
        var aux = pacienteService.buscar(cpf);
        return ResponseEntity.ok(aux);
    }






}
