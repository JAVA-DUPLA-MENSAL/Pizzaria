package br.com.projeto.pizzaria.dto;

import br.com.projeto.pizzaria.entity.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private String tamanho;

    private Boolean entrega;

    private Pedido pedido;

    public ItemDTO(){

    }

    public ItemDTO(String tamanho, Boolean entrega, Pedido pedido) {
        this.tamanho = tamanho;
        this.entrega = entrega;
        this.pedido = pedido;
    }
}
