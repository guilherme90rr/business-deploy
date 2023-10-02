package aula.business.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import aula.business.models.Categoria;
import aula.business.models.Documento;
import aula.business.repository.CategoriaRepository;
import aula.business.repository.DocumentoRepository;

@Configuration
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria(1, "color1", "Categoria 1");
        Categoria categoria2 = new Categoria(2, "color2", "Categoria 2");
        Categoria categoria3 = new Categoria(3, "color3", "Categoria 3");

        categoriaRepository.saveAll(List.of(categoria1, categoria2, categoria3));

        Documento documento1 = new Documento(1, "12345678901", "Documento 1", "Conteúdo do documento 1", categoria1);
        Documento documento2 = new Documento(2, "23456789012", "Documento 2", "Conteúdo do documento 2", categoria2);
        Documento documento3 = new Documento(3, "34567890123", "Documento 3", "Conteúdo do documento 3", categoria3);

        documentoRepository.saveAll(List.of(documento1, documento2, documento3));
    }
}
