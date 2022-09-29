package edu.ifrs.conhecimentoatravesvideos.model;

import javax.persistence.Entity;

@Entity
public class Video extends Entidade {

    private String nome;
    private String url;
    private String descricao;
    // private Autor autor;
    // private Playlist playlist;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    /*
     * public Autor getAutor() {
     * return autor;
     * }
     * 
     * public void setAutor(Autor autor) {
     * this.autor = autor;
     * }
     * 
     * public Playlist getPlaylist() {
     * return playlist;
     * }
     * 
     * public void setPlaylist(Playlist playlist) {
     * this.playlist = playlist;
     * }
     */
}