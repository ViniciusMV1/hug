package br.com.hug.controller;

import br.com.hug.models.Paciente;
import br.com.hug.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity criar(Paciente paciente){
        var p = pacienteService.criar(paciente);
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        var pacientes = pacienteService.buscarTodos();
        return ResponseEntity.ok(pacientes);
    }



}
