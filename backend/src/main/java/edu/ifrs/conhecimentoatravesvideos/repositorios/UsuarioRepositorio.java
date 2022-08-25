package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}
