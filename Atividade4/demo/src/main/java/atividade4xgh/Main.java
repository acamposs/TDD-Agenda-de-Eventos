package atividade4xgh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Evento> eventos = new ArrayList<Evento>();

    public static void main(String[] args) throws IOException {
        System.out.println("Digite a ação (adicionar, remover, mostrar, sair):");

        String acao = System.console().readLine();
        if (acao.equals("adicionar")) {
            adicionar();
        }

    }

    private static void adicionar() {
        System.out.println("Digite o nome do evento:");
        String nome = System.console().readLine();
        System.out.println("Digite a hora de início do evento:");
        String dataInicio = System.console().readLine();
        System.out.println("Digite a hora de fim do evento:");
        String dataFim = System.console().readLine();
        System.out.println("Evento adicionado com sucesso!");
        Evento evento = new Evento(nome, dataInicio, dataFim);
        eventos.add(evento);
    }

}