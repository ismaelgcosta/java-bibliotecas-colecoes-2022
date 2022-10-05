package br.com.bluesoft.movimentocodar.inscricoes.menus.relatorios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.menus.Menu;
import br.com.bluesoft.movimentocodar.inscricoes.menus.MenuExecutor;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

import static org.junit.jupiter.api.Assertions.*;

class MenuRelatoriosTest {

    @InjectMocks
    private MenuRelatorios menuRelatorios;

    @Mock
    private Menu menu;

    @Mock
    private Scanner scanner;

    @Test
    void opcoes() {

        Map<String, Opcao> opcoes = menuRelatorios.opcoes();

        assertInstanceOf(OpcaoCandidatosPorIdade.class, opcoes.get("1"));
        assertInstanceOf(OpcaoQtdCandidatosPorIdade.class, opcoes.get("2"));
        Opcao opcaoSair = opcoes.get("9");
        assertInstanceOf(OpcaoSair.class, opcaoSair);
    }

    @Test
    void getScanner() {
        assertEquals(scanner, menuRelatorios.getScanner());
    }
}