package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.candidatura.Formulario;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class OpcaoRemoverPergunta implements Opcao {

    private final Scanner scanner;

    public OpcaoRemoverPergunta(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getDescricao() {
        return "Remover pergunta do formulário";
    }

    @Override
    public void executar() {
        String pergunta = escolhaAPergunta();

        Formulario formulario = new Formulario();
        int perguntaSelecionada = Integer.parseInt(pergunta);

        if (perguntaSelecionada == 0) {
            return;
        }

        formulario.removerPergunta(perguntaSelecionada);
        escolhaAPergunta();

        System.out.println("-----------------------------");
        System.out.println("Pergunta removida com sucesso");
        System.out.println("-----------------------------");
    }

    private String escolhaAPergunta() {
        System.out.println("Informe a pergunta a ser removida ou 0 (zero) para retornar ao menu principal: ");

        new Formulario()
            .listarPerguntas()
            .forEach(pergunta -> {
                String[] numeroEPergunta = pergunta.split("\\|");
                System.out.println(numeroEPergunta[0].replace("P", "") + ") " + numeroEPergunta[1]);
            });

        String resposta = scanner.nextLine();
        while (resposta == null) {
            System.out.println("Pergunta inválida. Por favor, informe a pergunta");
            resposta = escolhaAPergunta();
        }

        return resposta;
    }
}
