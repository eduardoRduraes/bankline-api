package br.com.erd.banklineapi.controllers;

import br.com.erd.banklineapi.dtos.MovimentacaoDTO;
import br.com.erd.banklineapi.services.MovimentacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService){
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMovimentacao(@RequestBody MovimentacaoDTO data){
        return ResponseEntity.status(200).body(this.movimentacaoService.create(data));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findMovimentacao(@PathVariable("id") long id){
        return ResponseEntity.status(200).body(this.movimentacaoService.find(id));
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAllMovimentacao(){
        return ResponseEntity.status(200).body(this.movimentacaoService.findall());
    }
}
