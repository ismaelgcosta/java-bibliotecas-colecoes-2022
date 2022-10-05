package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import java.io.InputStream;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.candidatura.Formulario;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class OpcaoAdicionarPergunta implements Opcao {

    private final Scanner scanner;

    public OpcaoAdicionarPergunta(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getDescricao() {
        return "Adicionar pergunta ao formulário";
    }

    @Override
    public void executar() {
        String pergunta = digiteAPergunta();

        Formulario formulario = new Formulario();
        formulario.adicionarPergunta(pergunta);

        System.out.println("Pergunta cadastrada com sucesso");
    }

    private String digiteAPergunta() {
        System.out.println("Informe a pergunta: ");

        String resposta = scanner.nextLine();
        while (resposta == null) {
            System.out.println("Pergunta inválida. Por favor, informe a pergunta");
            resposta = digiteAPergunta();
        }

        return resposta;
    }
}
