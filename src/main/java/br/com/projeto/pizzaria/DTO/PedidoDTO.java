package br.com.projeto.pizzaria.DTO;

import br.com.projeto.pizzaria.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
    private String nome;

    private String observacao;

    private Usuario usuario;

    public PedidoDTO(){

    }

    public PedidoDTO(String nome, String observacao, Usuario usuario) {
        this.nome = nome;
        this.observacao = observacao;
        this.usuario = usuario;
    }
}
