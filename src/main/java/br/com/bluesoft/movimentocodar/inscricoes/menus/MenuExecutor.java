package br.com.bluesoft.movimentocodar.inscricoes.menus;

import java.util.Scanner;

public class MenuExecutor {
    private final Scanner scanner;
    private final Menu menu;

    private int tentativas = 0;

    public MenuExecutor(Menu menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
    }

    public void execute() {
        if(tentativas == 3) {
            System.out.println("Retornando ao menu anterior");
            return;
        }

        menu.opcoes().forEach((comando, opcao) -> System.out.println(comando + " - " + opcao.getDescricao()));

        String input = scanner.next();

        Opcao opcao = menu.opcoes().get(input);

        while (opcao == null && tentativas < 3) {
            tentativas++;
            System.out.println("Comando inválido, selecione uma opção existente");
            execute();
        }

        if(opcao != null) {
            opcao.executar();
            execute();
        }
    }
}
