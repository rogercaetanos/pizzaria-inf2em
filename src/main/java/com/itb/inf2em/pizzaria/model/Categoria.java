package com.itb.inf2em.pizzaria.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Categoria" )
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 45)
    private String nome;
    @Column(nullable = true,length = 255)
    private String descricao;
    private boolean codStatus;

    // Atributos de apoio

    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCodStatus() {
        return codStatus;
    }

    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
    public boolean validarCategoria() {

        return isValid;

    }

}
