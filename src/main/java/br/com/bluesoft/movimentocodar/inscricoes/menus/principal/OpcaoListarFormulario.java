package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.menus.MenuExecutor;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;
import br.com.bluesoft.movimentocodar.inscricoes.menus.relatorios.MenuRelatorios;

public class OpcaoListarFormulario implements Opcao {

    private final Scanner scanner;

    public OpcaoListarFormulario(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getDescricao() {
        return "Listar formulários cadastrados";
    }

    @Override
    public void executar() {
        new MenuExecutor(new MenuRelatorios(scanner), scanner).execute();
    }
}
