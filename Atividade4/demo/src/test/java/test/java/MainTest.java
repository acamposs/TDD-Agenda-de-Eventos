package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade4xgh.Main;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testMensagemInicial() throws IOException {
        Main.main(null);

        assertEquals("Digite a ação (adicionar, remover, mostrar, sair):", outputStreamCaptor.toString()
                .trim().split("\n")[0]);

    }

    @Test
    void testAdicionarComSucesso() throws IOException {
        Main.main(null);

        ByteArrayInputStream in = new ByteArrayInputStream("adicionar".getBytes());
        System.setIn(in);

        assertEquals("Digite o nome do evento:", outputStreamCaptor.toString().trim().split("\n")[1]);

        in = new ByteArrayInputStream("final dos 100m".getBytes());
        System.setIn(in);
        assertEquals("Digite a hora de início do evento:", outputStreamCaptor.toString().trim().split("\n")[2]);

        in = new ByteArrayInputStream("2024-07-24 10:00".getBytes());
        System.setIn(in);
        assertEquals("Digite a hora de fim do evento:", outputStreamCaptor.toString().trim().split("\n")[3]);

        in = new ByteArrayInputStream("2024-07-24 11:00".getBytes());
        System.setIn(in);

        assertEquals("Evento adicionado com sucesso!", outputStreamCaptor.toString().trim().split("\n")[4]);
    }
}
