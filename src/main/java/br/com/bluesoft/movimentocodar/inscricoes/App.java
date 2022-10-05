package br.com.bluesoft.movimentocodar.inscricoes;

import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.menus.MenuExecutor;
import br.com.bluesoft.movimentocodar.inscricoes.menus.principal.MenuPrincipal;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new MenuExecutor(new MenuPrincipal(scanner), scanner).execute();
    }
}