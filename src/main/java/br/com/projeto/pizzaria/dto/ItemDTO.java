package br.com.projeto.pizzaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemDTO {

    private Long id;

    private PedidoDTO pedidoDTO;

    private String tamanho;

    private Boolean entrega;

    private List<SaboresDTO> sabores;

    public ItemDTO(){

    }

    public ItemDTO(Long id, PedidoDTO pedidoDTO, String tamanho, Boolean entrega, List<SaboresDTO> saboresDTO) {
        this.id = id;
        this.pedidoDTO = pedidoDTO;
        this.tamanho = tamanho;
        this.entrega = entrega;
        this.sabores = saboresDTO;
    }
}
