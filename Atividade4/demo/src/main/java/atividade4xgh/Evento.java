package atividade4xgh;

import java.time.LocalDateTime;

public class Evento {
    String nome;
    LocalDateTime dataInicio;
    LocalDateTime dataFim;

    public Evento(String nome, String dataInicio, String dataFim) {
        this.nome = nome;
        this.dataInicio = LocalDateTime.parse(dataInicio);
        this.dataFim = LocalDateTime.parse(dataFim);
    }
}
