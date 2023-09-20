package br.com.projeto.pizzaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
    private Long id;

    private String nome;

    private String observacao;

    private UsuarioDTO usuario;

    public PedidoDTO(){

    }

    public PedidoDTO(Long id, String nome, String observacao, UsuarioDTO usuarioDTO) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.usuario = usuarioDTO;
    }
}
