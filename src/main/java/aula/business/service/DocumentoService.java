package aula.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aula.business.models.Documento;
import aula.business.repository.DocumentoRepository;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }

    public Documento findById(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    public void delete(Long id) {
        documentoRepository.deleteById(id);
    }
}
