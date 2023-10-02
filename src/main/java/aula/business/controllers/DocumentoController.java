package aula.business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aula.business.models.Documento;
import aula.business.service.DocumentoService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@Tag(name = "documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public ResponseEntity<List<Documento>> getAllDocumentos() {
        List<Documento> documentos = documentoService.findAll();
        return ResponseEntity.ok(documentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> getDocumentoById(@PathVariable Long id) {
        Documento documento = documentoService.findById(id);
        if (documento != null) {
            return ResponseEntity.ok(documento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        Documento savedDocumento = documentoService.save(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documento> updateDocumento(@PathVariable Long id, @RequestBody Documento documento) {
        Documento existingDocumento = documentoService.findById(id);
        if (existingDocumento != null) {
            documento.setDoc_id(id);
            Documento updatedDocumento = documentoService.save(documento);
            return ResponseEntity.ok(updatedDocumento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        Documento existingDocumento = documentoService.findById(id);
        if (existingDocumento != null) {
            documentoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
