package br.com.erd.banklineapi.controllers;

import br.com.erd.banklineapi.dtos.NovoCorrentista;
import br.com.erd.banklineapi.model.Correntista;
import br.com.erd.banklineapi.services.CorrentistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    private final CorrentistaService correntistaService;

    public CorrentistaController(CorrentistaService correntistaService){
        this.correntistaService = correntistaService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCorrentista(@RequestBody NovoCorrentista data){


        return ResponseEntity.status(200).body(this.correntistaService.create(data));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCorrentista(@RequestBody Correntista data, @PathVariable("id") long id){
        var correntista = this.correntistaService.find(id);
        ResponseEntity message;

        if(correntista != null){
            this.correntistaService.update(id, data);
            message = ResponseEntity.status(201).body("dados alterados com sucesso!");
        }else{
            message = ResponseEntity.status(401).body("Correntista não encontrado");
        }
        return message;
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findCorrentista(@PathVariable("id") long id){
        return ResponseEntity.status(201).body(this.correntistaService.find(id));
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findTodosCorrentista(){
        return ResponseEntity.status(201).body(this.correntistaService.list());
    }

}
