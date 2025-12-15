package com.projetoextensao.lista_de_tarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.projetoextensao.lista_de_tarefas.model.Tarefa;
import com.projetoextensao.lista_de_tarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return service.salvar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

