# Agenda de Eventos com Desenvolvimento Orientado a Testes (TDD)
Atividade da matéria Testes de Software ministrada pela Profa. Dra. ELaine Venson. Este projeto é uma aplicação de agenda de eventos implementada em Java, utilizando a abordagem de Desenvolvimento Orientado a Testes (TDD). Ele permite a criação, visualização e remoção de eventos, com verificação de conflitos de horário. O projeto tem como objetivo aprender a  aplicação do Desenvolvimento Orientado a Testes.

## Funcionalidades Obrigatórias 
1. **Adicionar Evento**: Permite adicionar eventos especificando nome, data de início e data de término. A aplicação verifica se há conflitos de horário com eventos exixtentes antes de adicionar um novo.
2. **Remover Evento**: Remove um evento existente a partir do nome especificado
3. **Mostrar Evento**: Exibe todos os eventos agendados.
4. **Verificar Conflitos**: Garante que eventos não tenham horários sobrepostos, impedindo a inclusão de novos eventos que gerem conflitos.

## Estrutura de Projeto
O projeto é composto pelos seuintes arquivos principais:

#### ` Evento.java `
Representa um evento com as seguintes propriedades:
- ` String nome `: Nome do evento.
- ` LocalDateTime dataInicio  `: Data e hora de início do evento.
- ` LocalDateTime dataFim  `: Data e hora de término do evento.

#### ` Main.java `
Gerencia a interação com o usuário e realiza as operações de manipulação de eventos:
- Adicionar eventos.
- Remover eventos.
- Mostrar eventos.
- Validar se o horário de um novo evento conflita com horários de eventos existentes.

#### ` MainTest.java ` 
Contém testes automatizados para garantir a funcionalidade correta da aplicação. Os testes cobrem os seguintes cenários:
- Adição de eventos sem conflitos.
- Tentativa de adicionar eventos com conflitos de horário.
- Remoção de eventos existentes.
- Remoção de eventos inexistentes.
- Exibição de eventos agendados.
- Teste de entrada de dados inválida (como datas no formato errado ou nome vazio).

## Pré-requisitos
- [Java 11+](https://www.oracle.com/java/technologies/downloads/#java11?er=221886) instalado.
- JUnit 5 para testes automatizados.

## Como Executar o Projeto

1. Clone o repositório:

```bash 
git clone https://github.com/usuario/agenda-eventos.git
 ```
2. Navegue até o diretório do projeto:

```bash 
cd agenda-eventos
 ```
3. Compile os arquivos Java:

```bash 
javac -d bin src/atividade4xgh/*.java
 ```
5. Execute a aplicação:

```bash 
java -cp bin atividade4xgh.Main
 ```

## Como Executar os Testes 
1. Certifique-se de ter o JUnit configurado no seu ambiente.
2. Compile os arquivos de teste:


```bash 
javac -cp "path/para/junit5.jar" -d bin src/test/java/*.java
 ```
4. Execute os testes:


```bash 
java -jar path/para/junit5.jar --class-path bin --scan-class-path
 ```

### Exemplos de Uso

#### Adicionar um evento
```bash 
Digite a ação (adicionar, remover, mostrar, sair):
adicionar
Digite o nome do evento:
Reunião de Equipe
Digite a hora de início do evento (yyyy-MM-dd HH:mm):
2024-10-12 09:00
Digite a hora de fim do evento (yyyy-MM-dd HH:mm):
2024-10-12 10:00
Evento adicionado com sucesso!
 ```

#### Remover um Evento
```bash 
Digite a ação (adicionar, remover, mostrar, sair):
remover
Digite o nome do evento:
Reunião de Equipe
Evento removido com sucesso.
 ```

#### Mostrar Todos os Eventos
```bash 
Digite a ação (adicionar, remover, mostrar, sair):
mostrar
Reunião de Equipe: 2024-10-12 09:00 a 2024-10-12 10:00
 ```

### Contribuidores
- [Amanda Campos](https://github.com/acamposs)
- [Kaio Enzo](https://github.com/kaioenzo)





  


