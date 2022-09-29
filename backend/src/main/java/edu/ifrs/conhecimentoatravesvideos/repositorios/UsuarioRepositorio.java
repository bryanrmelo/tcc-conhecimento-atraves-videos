package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);
    
}
