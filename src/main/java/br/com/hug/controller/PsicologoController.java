package br.com.hug.controller;

import br.com.hug.models.empresa.EmpresaRecord;
import br.com.hug.models.empresa.EmpresaResponse;
import br.com.hug.models.psicologo.Psicologo;
import br.com.hug.services.PsicologoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/psicologos")
public class PsicologoController {

    @Autowired
    private PsicologoService psicologoService;

    @PostMapping
        public ResponseEntity criar(@RequestBody @Valid Psicologo psicologo, UriComponentsBuilder builder){
            var aux = psicologoService.criar(psicologo);
            var uri = builder.path("/psicologos/{crp}").buildAndExpand(aux.getCrp()).toUri();
            return ResponseEntity.created(uri).body(aux);
        }

    @GetMapping
        public ResponseEntity buscarTodos(){
            var psicologos = psicologoService.buscarTodos();
            return ResponseEntity.ok(psicologos);
        }

    @DeleteMapping("/{crp}")
        public ResponseEntity deletar(@PathVariable String crp){
            psicologoService.deletar(crp);
            return ResponseEntity.notFound().build();
        }

    @PutMapping("/{crp}")
        public ResponseEntity atualizar(@PathVariable String crp, @RequestBody @Valid Psicologo psicologo){
            if (!psicologoService.existePsicologo(crp)) {
                return ResponseEntity.notFound().build();
            }
            var psicologo1 = psicologoService.atualizar(crp, psicologo);
            return ResponseEntity.ok(new Psicologo(psicologo1));
        }


    }

