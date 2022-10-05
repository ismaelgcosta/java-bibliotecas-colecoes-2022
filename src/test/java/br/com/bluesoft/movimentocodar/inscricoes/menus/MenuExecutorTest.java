package br.com.bluesoft.movimentocodar.inscricoes.menus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuExecutorTest {

    @InjectMocks
    private MenuExecutor menuExecutor;

    @Mock
    private Menu menu;

    @Mock
    private Scanner scanner;

    @Mock
    private PrintStream printStream;

    @Mock
    private Opcao opcao;
    @Mock
    private Opcao opcao2;

    @BeforeEach
    public void setUp() {

        Map<String, Opcao> map = new LinkedHashMap<>();
        map.put("1", opcao);
        map.put("2", opcao2);

        when(menu.opcoes()).thenReturn(map);
        when(opcao.getDescricao()).thenReturn("Opção 1");
        when(opcao2.getDescricao()).thenReturn("Opção 2");

        System.setOut(printStream);
    }

    @Test
    void executaMenu() {
        when(scanner.next()).thenReturn("1");
        menuExecutor.execute();

        InOrder inOrder = inOrder(printStream, scanner, opcao);
        inOrder.verify(printStream).println("1 - Opção 1");
        inOrder.verify(printStream).println("2 - Opção 2");
        inOrder.verify(scanner).next();
        inOrder.verify(opcao).executar();
    }

    @Test
    void deveValidarExecucaoDoMenuESairNaTerceiraTentativa() {
        menuExecutor.execute();

        InOrder inOrder = inOrder(printStream, scanner, opcao);
        inOrder.verify(scanner).next();
        inOrder.verify(printStream).println("1 - Opção 1");
        inOrder.verify(printStream).println("2 - Opção 2");
        inOrder.verify(printStream, times(2)).println("Comando inválido, selecione uma opção existente");
        inOrder.verify(printStream).println("Retornando ao menu anterior");
        inOrder.verify(opcao, never()).executar();
    }
}