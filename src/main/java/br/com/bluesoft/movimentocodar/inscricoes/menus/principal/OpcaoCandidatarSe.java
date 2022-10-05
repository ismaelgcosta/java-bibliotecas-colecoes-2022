package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.inscricoes.candidatura.Candidatura;
import br.com.bluesoft.movimentocodar.inscricoes.candidatura.Formulario;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

public class OpcaoCandidatarSe implements Opcao {

    private final Scanner scanner;
    private final Formulario formulario;

    public OpcaoCandidatarSe(Scanner scanner, Formulario formulario) {
        this.scanner = scanner;
        this.formulario = formulario;
    }

    @Override
    public String getDescricao() {
        return "Candidatar-se";
    }

    @Override
    public void executar() {

        List<String> respostas = new ArrayList<>();
        formulario
            .listarPerguntas()
            .forEach(pergunta -> respostas.add(pergunta.split("\\|")[0] + "|" + realizarPergunta(pergunta)));

        Candidatura candidatura = new Candidatura(respostas);
        candidatura.realizarInscricao();

        System.out.println("Obrigado por participar!!");

    }

    private String realizarPergunta(String pergunta) {
        System.out.println(pergunta.replace("|", " - "));

        String resposta = scanner.nextLine();
        while (resposta == null) {
            System.out.println("Resposta inválida. Por favor, responda a pergunta");
            resposta = realizarPergunta(pergunta);
        }

        return resposta;
    }
}
