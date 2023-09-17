package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.convert.UsuarioDTOConvert;
import br.com.projeto.pizzaria.dto.PedidoDTO;
import br.com.projeto.pizzaria.entity.Pedido;
import br.com.projeto.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioDTOConvert usuarioDTOConvert;


    public PedidoDTO criar(PedidoDTO pedidoDTO){

       Pedido pedido = toPedido(pedidoDTO);

       pedidoRepository.save(pedido);

       return toPedidoDTO(pedido);
    }

    public PedidoDTO findById(Long id){
        Pedido pedidoBanco = pedidoRepository.findById(id).orElse(null);

        return toPedidoDTO(pedidoBanco);
    }

    public List<PedidoDTO> findAllPedido(){
        List<Pedido> pedidosBanco = pedidoRepository.findAll();
        List<PedidoDTO> pedidoDTOList = new ArrayList<>();

        for(int i = 0; i < pedidosBanco.size(); i++){
            pedidoDTOList.add(toPedidoDTO(pedidosBanco.get(i)));
        }

        return pedidoDTOList;
    }

    public PedidoDTO editar(Long id, PedidoDTO pedidoDTO){
        Pedido pedido = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedido != null, "Pedido nao encontrado");

        this.pedidoRepository.save(toPedido(pedidoDTO));

        return pedidoDTO;
    }

    public String deletar(Long id){
        Pedido pedido = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedido != null, "Pedido nao encontrado");

        this.pedidoRepository.delete(pedido);

        return "Pedido deletado";
    }

    public PedidoDTO toPedidoDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setNome(pedido.getNome());
        pedidoDTO.setObservacao(pedido.getObservacao());
        pedidoDTO.setUsuarioDTO(usuarioDTOConvert.convertUsuarioToUsuarioDTO(pedido.getUsuario()));

        return pedidoDTO;
    }

    public Pedido toPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        pedido.setNome(pedidoDTO.getNome());
        pedido.setObservacao(pedidoDTO.getObservacao());
        pedido.setUsuario(usuarioDTOConvert.convertUsuarioDTOToUsuario(pedidoDTO.getUsuarioDTO()));

        return pedido;
    }
}
