package br.com.bluesoft.movimentocodar.inscricoes.fileutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArquivoLeitura {

    private final URL resource;

    public ArquivoLeitura(String file) {
        resource = getClass().getResource(file);
    }

    public ArquivoLeitura(File file) {
        try {
            resource = file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getLinhas() {
        try {
            FileReader reader = new FileReader(resource.getPath());
            try (BufferedReader br = new BufferedReader(reader)) {
                return br.lines().toList();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path getFilePath() {
        try {
            return Path.of(new File(resource.toURI()).getAbsoluteFile().getAbsolutePath());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
