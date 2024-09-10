package br.edu.famper.funcionarios.controller;

import br.edu.famper.funcionarios.model.Funcionario;
import br.edu.famper.funcionarios.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@RestController // Melhor usar @RestController aqui, pois combina @Controller e @ResponseBody
@RequestMapping("api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService FuncionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(FuncionarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcionario>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(FuncionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(FuncionarioService.salvar(funcionario));
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(FuncionarioService.salvar(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        FuncionarioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}


