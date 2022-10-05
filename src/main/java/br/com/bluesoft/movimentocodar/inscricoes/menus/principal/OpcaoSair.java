package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class OpcaoSair implements Opcao {

    @Override
    public String getDescricao() {
        return "Sair";
    }

    @Override
    public void executar() {
        System.exit(0);
    }
}
