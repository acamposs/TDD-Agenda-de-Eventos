package atividade4xgh;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Evento> eventos = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        while (true) {
            String acao = getAcao();
            if (acao.equals("adicionar")) {
                adicionar();
            } else if(acao.equals("sair"))
                break;
        }
    }

    private static String getAcao() {
        System.out.println("Digite a ação (adicionar, remover, mostrar, sair):");
        return sc.nextLine();
    }

    private static void adicionar() {
        System.out.println("Digite o nome do evento:");
        String nome =sc.nextLine();
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

    private static boolean validaConflitoHorario(Evento novoEvento) {
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
        }
        return true;
    }


}