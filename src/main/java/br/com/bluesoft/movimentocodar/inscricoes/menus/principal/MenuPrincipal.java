package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.candidatura.Formulario;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Menu;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class MenuPrincipal implements Menu {

    private final Scanner scanner;

    public MenuPrincipal(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Map<String, Opcao> opcoes() {
        Map<String, Opcao> opcoes = new LinkedHashMap<>();

        opcoes.put("1", new OpcaoCandidatarSe(new Scanner(System.in), new Formulario()));
        opcoes.put("2", new OpcaoAdicionarPergunta(new Scanner(System.in)));
        opcoes.put("3", new OpcaoRemoverPergunta(new Scanner(System.in)));
        opcoes.put("4", new OpcaoListarFormulario(new Scanner(System.in)));
        opcoes.put("5", new OpcaoValidarFormulario());
        opcoes.put("9", new OpcaoSair());

        return opcoes;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }
}
