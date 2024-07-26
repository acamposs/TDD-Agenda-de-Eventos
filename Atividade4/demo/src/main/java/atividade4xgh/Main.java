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
        String acao = getAcao();
        if (acao.equals("adicionar")) {
            adicionar();
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
        System.out.println("Evento adicionado com sucesso!");
        Evento evento = new Evento(nome, dataInicio, dataFim);
        eventos.add(evento);
    }
}