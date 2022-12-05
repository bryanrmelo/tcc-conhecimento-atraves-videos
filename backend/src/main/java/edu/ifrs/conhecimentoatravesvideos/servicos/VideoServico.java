package edu.ifrs.conhecimentoatravesvideos.servicos;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        video.setPlaylist(playlistServico.buscarPorId(video.getPlaylist().getId()));

        return videoRepositorio.save(video);
    }

    public List<Video> buscarPorNome(String nome) {
        Optional<List<Video>> v = videoRepositorio.findByNome(nome);
        try {
            return v.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Page<Video> buscarTodos(Pageable paginacao) {
        return videoRepositorio.findAll(paginacao);
    }

    public Video buscarPorId(Long id) {
        Optional<Video> v = videoRepositorio.findById(id);
        try {
            return v.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}
