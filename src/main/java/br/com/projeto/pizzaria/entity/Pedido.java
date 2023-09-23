package br.com.projeto.pizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;

    public Pedido(){

    }

    public Pedido(Long id, String nome, String observacao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.usuario = usuario;
    }
}
