package aula.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aula.business.models.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}