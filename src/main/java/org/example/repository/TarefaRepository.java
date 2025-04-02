package org.example.repository;

import org.example.model.Tarefa;
import org.example.model.Prioridade;

import java.util.List;

public interface TarefaRepository {
    void adicionarTarefa(Tarefa tarefa);
    List<Tarefa> listarTarefas();
    List<Tarefa> filtrarPorPrioridade(Prioridade prioridade);
}