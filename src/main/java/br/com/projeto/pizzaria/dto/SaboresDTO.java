package br.com.projeto.pizzaria.dto;

import br.com.projeto.pizzaria.entity.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaboresDTO {

    private Long id;

    private String nome;

    private List<Item> item;

    public SaboresDTO(){

    }

    public SaboresDTO(Long id, String nome, List<Item> item) {
        this.id = id;
        this.nome = nome;
        this.item = item;
    }
}
