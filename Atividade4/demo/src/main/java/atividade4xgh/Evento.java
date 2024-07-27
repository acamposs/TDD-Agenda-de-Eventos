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
        this.dataFim = LocalDateTime.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome + ": " +
                dataInicio.toString().replace("T", " ") +
                " a " +
                dataFim.toString().replace("T", " ") +
                System.lineSeparator();
    }
}
