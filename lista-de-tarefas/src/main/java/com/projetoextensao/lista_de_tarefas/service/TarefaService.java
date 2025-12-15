package com.projetoextensao.lista_de_tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetoextensao.lista_de_tarefas.model.Tarefa;
import com.projetoextensao.lista_de_tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listar() {
        return repository.findAll();
    }
}