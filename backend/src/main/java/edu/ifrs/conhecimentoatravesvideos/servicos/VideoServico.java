package edu.ifrs.conhecimentoatravesvideos.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.api.dto.VideoDTO;
import edu.ifrs.conhecimentoatravesvideos.api.mapeadores.VideoMapeador;
import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.repositorios.VideoRepositorio;

@Service
public class VideoServico {

    @Autowired
    private VideoRepositorio videoRepositorio;

    @Autowired
    private UsuarioServico usuarioServico;

    @Autowired
    private PlaylistServico playlistServico;

    @Autowired
    private VideoMapeador videoMapeador;

    public Video salvar(VideoDTO videoDTO) {

        Video video = videoMapeador.converterParaEntidade(videoDTO);
        video.setAutor(usuarioServico.buscarPorNome(video.getAutor().getNome()));
        System.out.println(video.getPlaylist().getId());
        video.setPlaylist(playlistServico.buscarPorId(video.getPlaylist().getId()));

        System.out.println(video.toString());

        return videoRepositorio.save(video);
    }

    public List<Video> buscarPorNome(String nome) {
        return videoRepositorio.findByNome(nome).get();
    }

    /*
     * public Page<Video> buscarTodos(Pageable paginacao) {
     * return videoRepositorio.findAll(paginacao);
     * }
     */
}
