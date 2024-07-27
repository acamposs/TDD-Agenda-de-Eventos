package atividade4xgh;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main{
    public static List<Evento> eventos = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        final var main = new Main();
        main.teste();

    }

    public void teste() {
         final var  sc = new Scanner(System.in);

        while (true) {
            String acao = getAcao(sc);
            if (acao.equals("adicionar")) {
                adicionar(sc);
            } else if (acao.equals("remover")) {
                remover(sc);
            } else if (acao.equals("mostrar")){
                mostrar(sc);
            }
            else if(acao.equals("sair"))
                break;
            else {
                System.out.println("Insira uma opção inválida (adicionar, remover, mostrar, sair).");
            }
        }
    }

    private String getAcao(Scanner sc) {
        System.out.println("Digite a ação (adicionar, remover, mostrar, sair):");
        if(sc.hasNextLine()){
            return sc.nextLine();
        }
        return null;
    }

    private void adicionar(Scanner sc) {
        System.out.println("Digite o nome do evento:");
        String nome = sc.nextLine();
        cadastraNome(nome, sc);
        System.out.println("Digite a hora de início do evento:");
        String dataInicio = cadastraData(sc);;
        System.out.println("Digite a hora de fim do evento:");
        String dataFim =  cadastraData(sc);
        Evento evento = new Evento(nome, dataInicio, dataFim);

        if(validaConflitoHorario(evento)) {
            eventos.add(evento);
            System.out.println("Evento adicionado com sucesso!");
        } else {
            System.out.println("O evento tem um horário de conflito com outro evento!");
        }
    }

    private void cadastraNome(String nome, Scanner sc) {
        while (nome.isBlank()) {
            System.out.println("Insira o nome do evento de forma que o nome não seja vazio.");
            nome = sc.nextLine();
        }
    }

    private String cadastraData(Scanner sc) {
        String data = sc.nextLine();

        while (!validaData(data)) {
            System.out.println("Insira o a data evento de forma válida, no formato yyyy-MM-dd HH:mm.");
            data = sc.nextLine();
        }

        return data;
    }

    private boolean validaData(String data) {
        if(data.isBlank()) return false;
        try {
            LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }

    private void mostrar(Scanner sc) {
        eventos.forEach(System.out::println);
    }

    private void remover(Scanner sc) {
        System.out.println("Digite o nome do evento para remover:");
        String nome = sc.nextLine();
        Optional<Evento> eventoOptional = eventos.stream().filter(e -> e.getNome().equals(nome)).findFirst();
        if(eventoOptional.isPresent()) {
            eventos.remove(eventoOptional.get());
            System.out.println("Evento removido com sucesso.");
        }
    }

    private boolean validaConflitoHorario(Evento novoEvento) {
        for (Evento eventoExistente : eventos) {
            if(eventoExistente.getDataInicio().isEqual(novoEvento.getDataInicio())
                    && eventoExistente.getDataFim().isEqual(novoEvento.getDataFim()))
            {
                return false;
            }
            if(
                    novoEvento.getDataInicio().isAfter(eventoExistente.getDataInicio()) &&
                    novoEvento.getDataFim().isAfter(eventoExistente.getDataFim())
            ) {
                return false;
            }

            if(
                    novoEvento.getDataInicio().isBefore(eventoExistente.getDataInicio()) &&
                    novoEvento.getDataFim().isAfter(eventoExistente.getDataInicio())
            )
            {
                return false;
            }
        }
        return true;
    }


}