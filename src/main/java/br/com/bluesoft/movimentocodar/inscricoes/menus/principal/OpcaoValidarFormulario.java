package br.com.bluesoft.movimentocodar.inscricoes.menus.principal;

import java.io.File;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.bluesoft.movimentocodar.inscricoes.candidatura.Candidatura;
import br.com.bluesoft.movimentocodar.inscricoes.fileutils.ArquivoLeitura;
import br.com.bluesoft.movimentocodar.inscricoes.menus.Opcao;

import static br.com.bluesoft.movimentocodar.inscricoes.candidatura.Candidatura.MOVIMENTO_CODAR_INSCRICOES;

public class OpcaoValidarFormulario implements Opcao {

    @Override
    public String getDescricao() {
        return "Validar formulários cadastrados";
    }

    @Override
    public void executar() {
        System.out.println(System.lineSeparator());
        System.out.println("--------------- CADASTROS DUPLICADOS -------------------");

        File[] candidaturas = Path.of(MOVIMENTO_CODAR_INSCRICOES)
            .toFile()
            .listFiles();

        Map<Candidatura, List<List<String>>> respostasPorCandidatura = Arrays.stream(candidaturas)
            .map(ArquivoLeitura::new)
            .map(ArquivoLeitura::getLinhas)
            .collect(Collectors.groupingBy(Candidatura::new));

        respostasPorCandidatura
            .entrySet()
                .stream()
            .filter( candidatura -> candidatura.getValue().size() > 0)
                .forEach(candidatura ->  {
                    String nomeCandidato = candidatura.getKey().getRespostasPorPergunta().get("P1");
                    String emailCandidato = candidatura.getKey().getRespostasPorPergunta().get("P2");
                    System.out.println(MessageFormat.format(" O candidato de Nome: {0} e email: {1}, está cadastrado {2} vezes no sistema",
                                                            nomeCandidato,
                                                            emailCandidato,
                                                            candidatura.getValue().size()));
                });

        System.out.println("------------------ FIM -----------------------");
        System.out.println(System.lineSeparator());
    }
}
