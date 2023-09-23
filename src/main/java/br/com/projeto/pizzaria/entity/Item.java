package br.com.projeto.pizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private String tamanho;

    private Boolean entrega;

    @ManyToMany
    @JoinTable(name = "item_sabores",
      joinColumns = @JoinColumn(name = "item_fk"),
      inverseJoinColumns = @JoinColumn(name = "sabores_fk"))
    private List<Sabores> sabores = new ArrayList<>();

    public Item(){

    }

    public Item(Long id, Pedido pedido, String tamanho, Boolean entrega, List<Sabores> sabores) {
        this.id = id;
        this.pedido = pedido;
        this.tamanho = tamanho;
        this.entrega = entrega;
        this.sabores = sabores;
    }

}
