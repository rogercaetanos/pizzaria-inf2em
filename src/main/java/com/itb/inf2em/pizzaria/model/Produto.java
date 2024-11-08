package com.itb.inf2em.pizzaria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    // Para obter o encapsulamento precisamos seguir alguns passos:
    // 1º: Trabalhar com os modificadores de acesso
    // Temos três modificadores de acesso:

    // public :   Acesso livre para todas as classes
    // private:   Acesso livre apenas dentro da classe
    // protected: Acesso livre apenas para as classes filhas (Sistema de Herança)

    // Logo, o 1º passo é utilizar o modificador de acesso "private" ou "protected" para os atributos.
    // 2º: Criar métodos de acesso ao atributo, dica: começar criando os métodos setter´s e getter´s
    // Obs: set -> Responsável em atribuir a informação
    //      get -> Responsável em recuperar a informação

    // PARA CADA ATRIBUTO TEREMOS O MÉTODO SET E O MÉTODO GET CORRESPONDENTE

    @Id                       // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // AUTO-INCREMENTO
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 255)
    private String descricao;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double precoVenda;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double precoCompra;
    @Column(nullable = true)
    private int quantidadeEstoque;
    @Column(nullable = true, length = 45)
    private String tipoProduto;
    private boolean codStatus;

    // Atributos de apoio

    @Transient                            // REPRESENTA ATRIBUTOS QUE NÃO SÃO COLUNAS
    @JsonIgnore
    private String mensagemErro = "";
    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {

    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
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

    public boolean validarProduto() {

        if(precoVenda < 0){
            precoVenda = 0;
            mensagemErro += "O preço do produto não pode ser menor que zero:";
            isValid = false;
        }
        if(nome == null || nome.isEmpty()) {
            mensagemErro += "O nome do produto é obrigatório:";
            isValid = false;
        }
        return isValid;
    }

}
