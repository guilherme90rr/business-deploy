package aula.business.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aula.business.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

}
