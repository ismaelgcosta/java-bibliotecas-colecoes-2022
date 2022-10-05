package br.com.bluesoft.movimentocodar.inscricoes.menus.relatorios;

import br.com.bluesoft.movimentocodar.inscricoes.menus.MenuExecutor;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class OpcaoSair implements Opcao {
    private final MenuExecutor menuExecutor;

    public OpcaoSair(MenuExecutor menuExecutor) {
        this.menuExecutor = menuExecutor;
    }

    @Override
    public String getDescricao() {
        return "Sair";
    }

    @Override
    public void executar() {
        menuExecutor.execute();
    }
}
