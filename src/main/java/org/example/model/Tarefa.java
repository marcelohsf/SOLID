package org.example.model;

public class Tarefa {
    private String titulo;
    private Prioridade prioridade;
    private boolean concluida;

    public Tarefa(String titulo, Prioridade prioridade) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return "[ " + (concluida ? "✔" : "✘") + " ] " + titulo + " (Prioridade: " + prioridade + ")";
    }
}