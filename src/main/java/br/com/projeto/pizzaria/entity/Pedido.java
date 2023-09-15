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



}
