package br.com.hug.controller;

import br.com.hug.models.psicologo.Psicologo;
import br.com.hug.services.PsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psicologos")
public class PsicologoController {

    @Autowired
    private PsicologoService psicologoService;

    @PostMapping
        public ResponseEntity criar(Psicologo psicologo){
            var psi = psicologoService.criar(psicologo);
            return ResponseEntity.ok(psi);
        }

    @GetMapping
        public ResponseEntity buscarTodos(){
            var psicologos = psicologoService.buscarTodos();
            return ResponseEntity.ok(psicologos);
        }
    }

