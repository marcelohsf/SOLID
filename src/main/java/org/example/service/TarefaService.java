package org.example.service;

import org.example.model.Tarefa;
import org.example.model.Prioridade;
import org.example.repository.TarefaRepository;

import java.util.List;

public class TarefaService {
    private final TarefaRepository repositorio;

    public TarefaService(TarefaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void criarTarefa(String titulo, Prioridade prioridade) {
        Tarefa novaTarefa = new Tarefa(titulo, prioridade);
        repositorio.adicionarTarefa(novaTarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repositorio.listarTarefas();
    }

    public List<Tarefa> filtrarPorPrioridade(Prioridade prioridade) {
        return repositorio.filtrarPorPrioridade(prioridade);
    }

    public void marcarComoConcluida(String titulo) {
        for (Tarefa tarefa : repositorio.listarTarefas()) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa.marcarComoConcluida();
                return;
            }
        }
        System.out.println("Tarefa não encontrada!");
    }
}