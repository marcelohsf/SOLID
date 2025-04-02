package org.example.view;

import org.example.model.Prioridade;
import org.example.model.Tarefa;
import org.example.repository.MemoriaTarefaRepository;
import org.example.service.TarefaService;

import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TarefaService tarefaService = new TarefaService(new MemoriaTarefaRepository());

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer do scanner

            switch (opcao) {
                case 1:
                    criarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    marcarTarefaConcluida();
                    break;
                case 4:
                    filtrarTarefasPorPrioridade();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n===== Gerenciador de Tarefas =====");
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Listar todas as tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Filtrar tarefas por prioridade");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarTarefa() {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.println("Escolha a prioridade (1: ALTA, 2: MÉDIA, 3: BAIXA): ");
        int prioridadeEscolhida = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        Prioridade prioridade = switch (prioridadeEscolhida) {
            case 1 -> Prioridade.ALTA;
            case 2 -> Prioridade.MEDIA;
            case 3 -> Prioridade.BAIXA;
            default -> {
                System.out.println("Prioridade inválida! Definindo como MÉDIA.");
                yield Prioridade.MEDIA;
            }
        };

        tarefaService.criarTarefa(titulo, prioridade);
        System.out.println("Tarefa criada com sucesso!");
    }

    private static void listarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    private static void marcarTarefaConcluida() {
        System.out.print("Digite o título da tarefa a ser concluída: ");
        String titulo = scanner.nextLine();
        tarefaService.marcarComoConcluida(titulo);
    }

    private static void filtrarTarefasPorPrioridade() {
        System.out.println("Filtrar por prioridade (1: ALTA, 2: MÉDIA, 3: BAIXA): ");
        int prioridadeEscolhida = scanner.nextInt();
        scanner.nextLine();

        Prioridade prioridade = Prioridade.values()[prioridadeEscolhida - 1];
        List<Tarefa> tarefasFiltradas = tarefaService.filtrarPorPrioridade(prioridade);

        if (tarefasFiltradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com essa prioridade.");
        } else {
            tarefasFiltradas.forEach(System.out::println);
        }
    }
}