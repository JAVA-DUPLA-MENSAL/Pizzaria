package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.ItemDTO;
import br.com.projeto.pizzaria.entity.Item;
import br.com.projeto.pizzaria.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemDTO criar(ItemDTO itemDTO){
        Item item = this.itemRepository.save(toItem(itemDTO));

        return toItemDTO(item);
    }

    public ItemDTO findById(Long id){
        Item itemBanco = itemRepository.findById(id).orElse(null);

        return toItemDTO(itemBanco);
    }

    public List

    public ItemDTO toItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setEntrega(item.getEntrega());
        itemDTO.setTamanho(item.getTamanho());
        itemDTO.setPedido(item.getPedido());

        return itemDTO;
    }

    public Item toItem(ItemDTO itemDTO){
        Item item = new Item();

        item.setEntrega(itemDTO.getEntrega());
        item.setTamanho(itemDTO.getTamanho());
        item.setPedido(itemDTO.getPedido());

        return item;
    }
}
