package br.com.bluesoft.movimentocodar.inscricoes.candidatura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.bluesoft.movimentocodar.inscricoes.fileutils.ArquivoEscrita;
import br.com.bluesoft.movimentocodar.inscricoes.fileutils.ArquivoLeitura;

public class Formulario {

    public static final String FORMULARIO_TXT = "formulario.txt";
    private final ArquivoLeitura formulario;

    public Formulario() {
        formulario = new ArquivoLeitura("../candidatura/" + FORMULARIO_TXT);
    }

    public List<String> listarPerguntas() {
        ArquivoLeitura arquivoLeitura = new ArquivoLeitura("../candidatura/" + FORMULARIO_TXT);
        return arquivoLeitura.getLinhas();
    }

    public void adicionarPergunta(String pergunta) {
        int proximaPergunta = listarPerguntas().size() + 1;

        try {
            ArquivoEscrita formulario = new ArquivoEscrita(this.formulario.getFilePath());
            formulario.escreverLinha("P" + proximaPergunta + "|" + pergunta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerPergunta(int pergunta) {
        try {

            if(pergunta >= 1 && pergunta <= 4) {
                System.out.println("Não é permitido remover as primeiras 4 perguntas do formulário por se tratarem de perguntas padrão");
                return;
            }

            ArquivoEscrita formulario = new ArquivoEscrita(this.formulario.getFilePath());
            formulario.removerLinha(listarPerguntas().get(pergunta - 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
