package edu.ifrs.conhecimentoatravesvideos.repositorios;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifrs.conhecimentoatravesvideos.model.Video;

@Repository
@Transactional
public interface VideoRepositorio extends JpaRepository<Video, Long> {
    
    //Pageable findAll(Pageable page);
}
