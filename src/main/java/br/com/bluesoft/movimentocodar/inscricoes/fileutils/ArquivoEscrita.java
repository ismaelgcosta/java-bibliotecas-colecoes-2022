package br.com.bluesoft.movimentocodar.inscricoes.fileutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ArquivoEscrita {

    private final File arquivoFisico;

    public ArquivoEscrita(String file) throws IOException {
        this(Path.of(file));
    }

    public ArquivoEscrita(Path filePath) throws IOException {
        arquivoFisico = filePath.toFile();
        if (!arquivoFisico.exists()) {
            if(!arquivoFisico.isDirectory()) {
                arquivoFisico.getParentFile().mkdirs();
                arquivoFisico.createNewFile();
            }
        }
    }

    public void escreverLinha(String linha) {
        try (FileWriter writer = new FileWriter(arquivoFisico, true)) {
            escreverLinha(linha, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void removerLinha(String linha) {
        ArquivoLeitura arquivoLeitura = new ArquivoLeitura(arquivoFisico);
        List<String> perguntas = arquivoLeitura
            .getLinhas();

        try (FileWriter writer = new FileWriter(arquivoFisico, false)) {
            perguntas.stream()
                .filter(line -> !line.equals(linha))
                .forEach(line -> escreverLinha(line, writer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void escreverLinha(String linha, FileWriter writer) {
        try {
            writer.write(linha);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
