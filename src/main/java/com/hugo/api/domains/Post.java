package com.hugo.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Post implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String conteudo;
    private Integer up = 0;
    private Integer down = 0;
    private Date data;

    public Post() { }

    public Post(Integer id, String titulo, String conteudo, Date data) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Integer getUp() {
        return up;
    }

    public Integer getDown() { return down; }

    public Date getData() {
        return data;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post posts = (Post) o;
        return id.equals(posts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
