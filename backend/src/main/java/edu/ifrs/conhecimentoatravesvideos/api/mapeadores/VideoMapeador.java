package edu.ifrs.conhecimentoatravesvideos.api.mapeadores;

import org.springframework.stereotype.Component;

import edu.ifrs.conhecimentoatravesvideos.api.dto.VideoDTO;
import edu.ifrs.conhecimentoatravesvideos.model.Playlist;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.model.Video;

@Component
public class VideoMapeador {

  public Video converterParaEntidade(VideoDTO videoDTO) {

    Usuario usuario = new Usuario(videoDTO.getAutor());
    Playlist playlist = new Playlist(videoDTO.getPlaylist());

    Video video = new Video();

    video.setTitulo(videoDTO.getTitulo());
    video.setLink(videoDTO.getLink());
    video.setAutor(usuario);
    video.setPlaylist(playlist);
    video.setCategoria(videoDTO.getCategoria());
    video.setPrivado(videoDTO.getPrivado());

    return video;
  }
}