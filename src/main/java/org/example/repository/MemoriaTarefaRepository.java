package org.example.repository;

import org.example.model.Tarefa;
import org.example.model.Prioridade;

import java.util.ArrayList;
import java.util.List;

public class MemoriaTarefaRepository implements TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    @Override
    public List<Tarefa> filtrarPorPrioridade(Prioridade prioridade) {
        List<Tarefa> resultado = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getPrioridade() == prioridade) {
                resultado.add(tarefa);
            }
        }
        return resultado;
    }
}