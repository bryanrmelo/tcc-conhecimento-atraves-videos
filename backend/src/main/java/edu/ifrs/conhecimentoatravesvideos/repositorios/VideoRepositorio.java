package edu.ifrs.conhecimentoatravesvideos.repositorios;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifrs.conhecimentoatravesvideos.model.Video;

@Repository
public interface VideoRepositorio extends JpaRepository<Video, Long> {
    
    Page<Video> findAll(Pageable page);
}
