package edu.ifrs.conhecimentoatravesvideos.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.api.dto.VideoDTO;
import edu.ifrs.conhecimentoatravesvideos.api.mapeadores.VideoMapeador;
import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.repositorios.VideoRepositorio;

@Service
public class VideoServico  {

    @Autowired
    private VideoRepositorio videoRepositorio;

    @Autowired
    private UsuarioServico usuarioServico;

    @Autowired
    private VideoMapeador videoMapeador;

    public Video salvar(VideoDTO videoDTO) {
        
        Video video = videoMapeador.converterParaEntidade(videoDTO);
        video.setAutor(usuarioServico.buscarPorNome(video.getAutor().getNome()));
        
        return videoRepositorio.save(video);
    }

    /* 
    public Page<Video> buscarTodos(Pageable paginacao) {
        return videoRepositorio.findAll(paginacao);
    }
    */
}
