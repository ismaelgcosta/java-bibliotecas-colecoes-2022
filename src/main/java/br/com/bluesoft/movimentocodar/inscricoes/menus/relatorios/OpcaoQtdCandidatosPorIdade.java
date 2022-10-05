package br.com.bluesoft.movimentocodar.inscricoes.menus.relatorios;

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

public class OpcaoQtdCandidatosPorIdade implements Opcao {

    @Override
    public String getDescricao() {
        return "Listar Número de Candidatos por Idade";
    }

    @Override
    public void executar() {

        System.out.println(System.lineSeparator());
        System.out.println("--------------- QUANTIDADE DE CANDIDATOS POR IDADE -------------------");

        File[] candidaturas = Path.of(MOVIMENTO_CODAR_INSCRICOES)
            .toFile()
            .listFiles();

        Map<Integer, List<Candidatura>> candidatosPorIdade = Arrays.stream(candidaturas)
            .map(ArquivoLeitura::new)
            .map(ArquivoLeitura::getLinhas)
            .map(Candidatura::new)
            .collect(Collectors.groupingBy(Candidatura::getIdadeCandidato));

        candidatosPorIdade.forEach((idade, candidatos) ->
                                       System.out.println(MessageFormat.format(" Idade : {0} anos. Número de Candidatos: {1}", idade, candidatos.size())));

        System.out.println("------------------ FIM -----------------------");
        System.out.println(System.lineSeparator());
    }
}
