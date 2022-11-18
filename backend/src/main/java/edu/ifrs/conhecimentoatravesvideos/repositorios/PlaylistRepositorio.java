package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifrs.conhecimentoatravesvideos.model.Playlist;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

@Repository
@Transactional
public interface PlaylistRepositorio extends JpaRepository<Playlist, Long> {

    //Pageable findAll(Pageable page);

    @Query("SELECT p FROM Playlist p JOIN Usuario u ON p.usuario = u.id WHERE p.usuario = :id")
    List<Playlist> findPlaylistByUsuario(@Param("id") Usuario usuario);
}
