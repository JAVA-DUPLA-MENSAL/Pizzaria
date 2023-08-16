package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.PedidoDTO;
import br.com.projeto.pizzaria.entity.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {


    public PedidoDTO toPedidoDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setNome(pedido.getNome());
        pedidoDTO.setObservacao(pedido.getObservacao());
        pedidoDTO.setUsuario(pedido.getUsuario());

        return pedidoDTO;
    }

    public Pedido toPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        pedido.setNome(pedidoDTO.getNome());
        pedido.setObservacao(pedidoDTO.getObservacao());
        pedido.setUsuario(pedidoDTO.getUsuario());

        return pedido;
    }
}
