package test.java;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.*;

import atividade4xgh.Main;

public class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() throws IOException {
        Main.eventos.clear();
    }

    @Test
    @Order(1)
    void testMensagemInicial() throws Exception {
        withTextFromSystemIn("sair\n")
                .execute(() -> {
                    Main.main(null);
                    assertEquals("Digite a ação (adicionar, remover, mostrar, sair):",
                            outputStreamCaptor.toString().trim().split("\n")[0]);
                });
    }

    @Test
    @Order(2)
    void testAdicionarComSucesso() throws Exception {
        withTextFromSystemIn("adicionar", "teste", "2024-07-24 10:00", "2024-07-24 11:00", "sair")
                .execute(() -> {
                    final var main = new Main();
                    main.teste();
                    String[] outputLines = outputStreamCaptor.toString().trim().split("\n");

                    assertEquals("Digite a ação (adicionar, remover, mostrar, sair):\r", outputLines[0]);
                    assertEquals("Digite o nome do evento:\r", outputLines[1]);
                    assertEquals("Digite a hora de início do evento:\r", outputLines[2]);
                    assertEquals("Digite a hora de fim do evento:\r", outputLines[3]);
                    assertEquals("Evento adicionado com sucesso!\r", outputLines[4]);
                });

    }

    @Test
    void testConflitoHorario() throws Exception {
        withTextFromSystemIn("adicionar", "final dos 100m", "2024-07-24 10:00", "2024-07-24 11:00",
                "adicionar", "final dos 200m", "2024-07-24 10:00", "2024-07-24 11:00", "sair")
                .execute(() -> {
                    final var main = new Main();
                    main.teste();
                    String[] outputLines = outputStreamCaptor.toString().trim().split("\n");
                    assertEquals("O evento tem um horário de conflito com outro evento!\r", outputLines[9]);
                });
    }

    @Test
    void testConflitoHorariosDiferentes() throws Exception {
        withTextFromSystemIn("adicionar", "final dos 100m", "2024-07-24 10:00", "2024-07-24 11:00",
                "adicionar","final dos 200m","2024-07-24 10:30","2024-07-24 11:30","sair")
                .execute(() -> {
                    final var main = new Main();
                    main.teste();
                    String[] outputLines = outputStreamCaptor.toString().trim().split("\n");
                    assertEquals("O evento tem um horário de conflito com outro evento!\r", outputLines[9]);
                });
    }

    @Test
    void testConflitoHorariosDiferentes2() throws Exception {
        withTextFromSystemIn("adicionar", "final dos 100m", "2024-07-24 10:00", "2024-07-24 11:00",
                "adicionar","final dos 200m","2024-07-24 09:10","2024-07-24 11:30","sair")
                .execute(() -> {
                    final var main = new Main();
                    main.teste();
                    String[] outputLines = outputStreamCaptor.toString().trim().split("\n");
                    assertEquals("O evento tem um horário de conflito com outro evento!\r", outputLines[9]);
                });
    }

    @Test
    void testRemoverEventoComSucesso() throws Exception {
        withTextFromSystemIn("adicionar", "final dos 100m", "2024-07-24 10:00", "2024-07-24 11:00",
                "remover", "final dos 100m", "sair")
                .execute(() -> {
                    final var main = new Main();
                    main.teste();
                    String[] outputLines = outputStreamCaptor.toString().trim().split("\n");

                    assertEquals("Digite o nome do evento para remover:\r", outputLines[6]);
                    assertEquals("Evento removido com sucesso.\r",
                            outputLines[7]
                    );
                });
    }
}
