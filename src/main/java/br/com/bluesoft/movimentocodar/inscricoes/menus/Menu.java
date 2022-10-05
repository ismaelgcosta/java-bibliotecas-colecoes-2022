package br.com.bluesoft.movimentocodar.inscricoes.menus;

import java.util.Map;
import java.util.Scanner;

public interface Menu {

    Map<String, Opcao> opcoes();

    Scanner getScanner();
}
