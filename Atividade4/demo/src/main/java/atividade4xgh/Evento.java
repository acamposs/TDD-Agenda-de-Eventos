package atividade4xgh;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    String nome;
    LocalDateTime dataInicio;
    LocalDateTime dataFim;

    public Evento(String nome, String dataInicio, String dataFim) {
        this.nome = nome;
        this.dataInicio = LocalDateTime.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.dataFim = LocalDateTime.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
