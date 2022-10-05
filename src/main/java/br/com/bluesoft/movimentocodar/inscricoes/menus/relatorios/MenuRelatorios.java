package br.com.bluesoft.movimentocodar.inscricoes.menus.relatorios;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.menus.Menu;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class MenuRelatorios implements Menu {

    private final Scanner scanner;

    public MenuRelatorios(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Map<String, Opcao> opcoes() {
        Map<String, Opcao> opcoes = new LinkedHashMap<>();

        opcoes.put("1", new OpcaoCandidatosPorIdade());
        opcoes.put("2", new OpcaoQtdCandidatosPorIdade());
        opcoes.put("9", new OpcaoSair(scanner));

        return opcoes;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }
}
