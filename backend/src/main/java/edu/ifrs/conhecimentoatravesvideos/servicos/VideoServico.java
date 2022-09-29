package edu.ifrs.conhecimentoatravesvideos.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.repositorios.VideoRepositorio;

@Service
public class VideoServico  {

    @Autowired
    private VideoRepositorio videoRepositorio;

    public Page<Video> buscarTodos(Pageable paginacao) {
        return videoRepositorio.findAll(paginacao);
    }
    
}