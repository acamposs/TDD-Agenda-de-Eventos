package atividade4xgh;

import java.io.Console;
import java.io.IOException;
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
            }
            else if(acao.equals("sair"))
                break;
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
        System.out.println("Digite a hora de início do evento:");
        String dataInicio =sc.nextLine();
        System.out.println("Digite a hora de fim do evento:");
        String dataFim =sc.nextLine();
        Evento evento = new Evento(nome, dataInicio, dataFim);

        if(validaConflitoHorario(evento)) {
            eventos.add(evento);
            System.out.println("Evento adicionado com sucesso!");
        } else {
            System.out.println("O evento tem um horário de conflito com outro evento!");
        }
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