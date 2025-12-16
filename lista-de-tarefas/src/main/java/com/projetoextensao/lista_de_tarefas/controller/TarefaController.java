package com.projetoextensao.lista_de_tarefas.controller;

import com.projetoextensao.lista_de_tarefas.model.Tarefa;
import com.projetoextensao.lista_de_tarefas.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }
    //100%
    //ok
    //Criar Tarefa retorna = 201 Created
    @PostMapping
    public ResponseEntity<Tarefa>  criar(@RequestBody @Valid  Tarefa tarefa) {
        Tarefa salva = repository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // retorna 200 ok
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa dados) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tarefa não encontrada"));

        tarefa.setDescricao(dados.getDescricao());
        tarefa.setConcluida(dados.isConcluida());
        tarefa.setPrioridade(dados.getPrioridade());

        return ResponseEntity.ok(repository.save(tarefa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){


        Tarefa tarefa = repository.findById(id)
                .orElseThrow(()  -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tarefa não encontrada"));

        repository.delete(tarefa);
        return ResponseEntity.noContent().build();
    }

    // 404 Not Found
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
        return ResponseEntity.ok(tarefa);
    }





}
