package br.com.bluesoft.movimentocodar.inscricoes.candidatura;

import java.io.IOException;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.bluesoft.movimentocodar.inscricoes.fileutils.ArquivoEscrita;

public class Candidatura {
    public static final String MOVIMENTO_CODAR_INSCRICOES = System.getProperty("user.home") + "/movimento-codar/inscricoes/";
    public static final String PERGUNTA_NOME = "P1";
    public static final String PERGUNTA_EMAIL = "P2";
    public static final String PERGUNTA_IDADE = "P3";

    private final List<String> respostas;

    public Candidatura(List<String> respostas) {
        this.respostas = respostas;
        if(respostas.size() < 4) {
            throw new RuntimeException("O número de respostas está inválido. Preencha novamente o cadastro");
        }
    }

    private String gerarNomeDoArquivo() {
        return MOVIMENTO_CODAR_INSCRICOES +
               obterProximoNumeroDeFormulario() + "-" +
               Normalizer.normalize(respostas.get(0).split("\\|")[1].toUpperCase().replaceAll(" ", "-"), Normalizer.Form.NFD) +
               ".txt";
    }

    private long obterProximoNumeroDeFormulario() {
        return Arrays.stream(Path.of(MOVIMENTO_CODAR_INSCRICOES).toFile().listFiles()).count() + 1;
    }

    public Map<String, String> getRespostasPorPergunta() {
        return respostas
            .stream()
            .collect(Collectors.toMap(pergunta ->  pergunta.split("\\|")[0], resposta -> resposta.split("\\|")[1]));
    }

    public String getNomeCandidato() {
        return getRespostasPorPergunta().get(PERGUNTA_NOME);
    }

    public Integer getIdadeCandidato() {
        return Integer.valueOf(getRespostasPorPergunta().get(PERGUNTA_IDADE));
    }

    public String getEmailCandidato() {
        return getRespostasPorPergunta().get(PERGUNTA_EMAIL);
    }

    public void realizarInscricao() {
        try {

            if (Integer.parseInt(respostas.get(2).split("\\|")[1]) < 16) {
                System.out.println("A idade mínima para participação do processo é de 16 anos. Inscreva-se novamente ao atingir a idade mínima necessária");
                return;
            }

            ArquivoEscrita inscricao = new ArquivoEscrita(gerarNomeDoArquivo());
            respostas.forEach(inscricao::escreverLinha);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Candidatura that)) {
            return false;
        }
        return Objects.equals(getNomeCandidato(), that.getNomeCandidato()) &&
               Objects.equals(getEmailCandidato(), that.getEmailCandidato());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomeCandidato(), getEmailCandidato());
    }
}
