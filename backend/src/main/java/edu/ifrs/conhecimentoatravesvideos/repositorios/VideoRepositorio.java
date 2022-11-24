package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifrs.conhecimentoatravesvideos.model.Video;

@Repository
@Transactional
public interface VideoRepositorio extends JpaRepository<Video, Long> {

    @Query(value = "SELECT v FROM Video v WHERE nome = ?1", nativeQuery = true)
    List<Video> findByNome(String nome);
    
    //Pageable findAll(Pageable page);
}
