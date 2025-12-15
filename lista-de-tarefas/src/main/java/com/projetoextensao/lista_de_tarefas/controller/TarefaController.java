package com.projetoextensao.lista_de_tarefas.controller;

import com.projetoextensao.lista_de_tarefas.model.Tarefa;
import com.projetoextensao.lista_de_tarefas.repository.TarefaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }
}
