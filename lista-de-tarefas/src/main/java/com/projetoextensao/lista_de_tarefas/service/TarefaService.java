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

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setDescricao(novaTarefa.getDescricao());
        tarefa.setConcluida(novaTarefa.isConcluida());

        return repository.save(tarefa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
