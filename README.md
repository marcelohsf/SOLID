
# Gerenciador de Tarefas - Aplicação dos Princípios SOLID

## Descrição
Este projeto é um gerenciador de tarefas simples desenvolvido em **Java** aplicando os princípios **SOLID**.  
O sistema funciona via console e permite criar, listar, filtrar e concluir tarefas, sem uso de banco de dados.

## Funcionalidades
✅ Criar tarefas  
✅ Listar tarefas  
✅ Marcar tarefas como concluídas  
✅ Filtrar tarefas por prioridade  
✅ Exibir relatório no console

## Aplicação dos Princípios SOLID

**1️⃣ S - Princípio da Responsabilidade Única (SRP)**  
Cada classe tem uma única responsabilidade:
- `Tarefa.java` → Representa uma tarefa.
- `TarefaService.java` → Gerencia a lógica das tarefas.
- `MemoriaTarefaRepository.java` → Armazena as tarefas em memória.

**2️⃣ O - Princípio Aberto/Fechado (OCP)**  
O sistema pode ser expandido sem modificar o código existente. Se quisermos salvar tarefas em um banco de dados, basta criar um novo repositório sem alterar outras classes.

**3️⃣ L - Princípio da Substituição de Liskov (LSP)**  
A classe `MemoriaTarefaRepository` implementa a interface `TarefaRepository`, garantindo que qualquer repositório futuro possa substituí-la sem problemas.

**4️⃣ I - Princípio da Segregação de Interfaces (ISP)**  
A interface `TarefaRepository` contém apenas os métodos necessários para manipular tarefas, evitando interfaces grandes e genéricas.

**5️⃣ D - Princípio da Inversão de Dependência (DIP)**  
O `TarefaService` não depende diretamente do `MemoriaTarefaRepository`, mas da interface `TarefaRepository`, permitindo fácil substituição da implementação no futuro.

## Alunos
👨‍💻 Ronan f. Alves
👨‍💻 Gabriel Cena
👨‍💻 Marcelo Henrique Silva

## Conclusão
Este projeto demonstra como os princípios SOLID melhoram a organização e a flexibilidade do código. Seguindo essas boas práticas, o sistema fica mais modular, fácil de manter e escalável. 
