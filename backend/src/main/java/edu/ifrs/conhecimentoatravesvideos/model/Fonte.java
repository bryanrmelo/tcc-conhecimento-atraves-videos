package edu.ifrs.conhecimentoatravesvideos.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fonte extends Entidade {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Blob texto;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Blob getTexto() {
        return this.texto;
    }

    public void setTexto(Blob texto) {
        this.texto = texto;
    }
}
