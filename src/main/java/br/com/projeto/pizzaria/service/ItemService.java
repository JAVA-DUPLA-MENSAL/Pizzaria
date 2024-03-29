package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.dto.ItemDTO;
import br.com.projeto.pizzaria.entity.Item;
import br.com.projeto.pizzaria.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PedidoService pedidoService;

    public ItemDTO criar(ItemDTO itemDTO){
        Item item = toItem(itemDTO);

        itemRepository.save(item);

        return toItemDTO(item);
    }

    public ItemDTO findById(Long id){
        Item itemBanco = itemRepository.findById(id).orElse(null);

        return toItemDTO(itemBanco);
    }

    public List<ItemDTO> findAllItens(){
        List<Item> itensBanco = itemRepository.findAll();
        List<ItemDTO> itensDTOList = new ArrayList<>();

        for(int i = 0; i < itensBanco.size(); i++){
            itensDTOList.add(toItemDTO(itensBanco.get(i)));
        }
        return itensDTOList;
    }

    public ItemDTO editar(Long id, ItemDTO itemDTO){
        Item item = this.itemRepository.findById(id).orElse(null);

        Assert.isTrue(item != null, "Item nao encontrado");

        this.itemRepository.save(toItem(itemDTO));

        return itemDTO;
    }

    public String deletar(Long id){
        Item item = this.itemRepository.findById(id).orElse(null);

        Assert.isTrue(item != null, "Item nao encontrado");

        this.itemRepository.delete(item);

        return "Item deletado";
    }

    public ItemDTO toItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId(item.getId());
        itemDTO.setEntrega(item.getEntrega());
        itemDTO.setTamanho(item.getTamanho());
        itemDTO.setPedidoDTO(pedidoService.toPedidoDTO(item.getPedido()));

        return itemDTO;
    }

    public Item toItem(ItemDTO itemDTO){
        Item item = new Item();

        item.setId(itemDTO.getId());
        item.setEntrega(itemDTO.getEntrega());
        item.setTamanho(itemDTO.getTamanho());
        item.setPedido(pedidoService.toPedido(itemDTO.getPedidoDTO()));

        return item;
    }
}
