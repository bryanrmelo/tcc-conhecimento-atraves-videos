package edu.ifrs.conhecimentoatravesvideos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Relation(collectionRelation = "usuarios")
public class Usuario extends Entidade {

    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @Size(min = 5, max = 255)
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}