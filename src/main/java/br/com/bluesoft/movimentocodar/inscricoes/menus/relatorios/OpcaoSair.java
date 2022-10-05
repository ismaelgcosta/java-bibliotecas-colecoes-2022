package br.com.bluesoft.movimentocodar.inscricoes.menus.relatorios;

import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.menus.MenuExecutor;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;
import br.com.bluesoft.movimentocodar.inscricoes.menus.principal.MenuPrincipal;

public class OpcaoSair implements Opcao {

    private final Scanner scanner;

    public OpcaoSair(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getDescricao() {
        return "Sair";
    }

    @Override
    public void executar() {
        new MenuExecutor(new MenuPrincipal(scanner), scanner).execute();
    }
}
