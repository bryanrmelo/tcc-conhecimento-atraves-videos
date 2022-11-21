package edu.ifrs.conhecimentoatravesvideos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Video extends Entidade {

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private boolean privado;

    @ManyToOne
    @JoinColumn(name="autor_id", nullable = false)
    private Usuario autor;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPrivado() {
        return this.privado;
    }

    public boolean getPrivado() {
        return this.privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
    /*
     * private Playlist playlist;
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