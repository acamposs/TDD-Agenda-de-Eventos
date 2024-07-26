package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
        System.setIn(System.in);
    }

    @Test
    void testMensagemInicial() throws IOException {
        String input = "sair\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(null);
        assertEquals("Digite a ação (adicionar, remover, mostrar, sair):", outputStreamCaptor.toString().trim().split("\n")[0]);
    }

    @Test
    void testAdicionarComSucesso() throws IOException {
        String input = "adicionar\nfinal dos 100m\n2024-07-24 10:00\n2024-07-24 11:00\nsair\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(null);
        String[] outputLines = outputStreamCaptor.toString().trim().split("\n");

        assertEquals("Digite a ação (adicionar, remover, mostrar, sair):\r", outputLines[0]);
        assertEquals("Digite o nome do evento:\r", outputLines[1]);
        assertEquals("Digite a hora de início do evento:\r", outputLines[2]);
        assertEquals("Digite a hora de fim do evento:\r", outputLines[3]);
        assertEquals("Evento adicionado com sucesso!", outputLines[4]);
    }
}
