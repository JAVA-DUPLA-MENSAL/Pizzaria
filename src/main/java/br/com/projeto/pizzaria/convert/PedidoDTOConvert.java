package br.com.projeto.pizzaria.convert;

import br.com.projeto.pizzaria.DTO.PedidoDTO;
import br.com.projeto.pizzaria.entity.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoDTOConvert {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoDTO convertPedidoDTOtoPedido(Pedido pedido){
        PedidoDTO pedidoDTO = modelMapper.map(pedido,PedidoDTO.class);

        return pedidoDTO;
    }

    public Pedido convertPedidotoPedidoDTO(PedidoDTO pedidoDTO){
        Pedido pedido = modelMapper.map(pedidoDTO,Pedido.class);

        return pedido;
    }
}
