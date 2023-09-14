package br.com.projeto.pizzaria.convert;



import br.com.projeto.pizzaria.DTO.ItemDTO;
import br.com.projeto.pizzaria.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class itemDTOConvert {

    @Autowired
    private ModelMapper modelMapper;

    public ItemDTO convertItemToItemDTO(Item item){
        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);

        return itemDTO;
    }

    public Item convertItemDTOToItem(ItemDTO itemDTO){
        Item item = modelMapper.map(itemDTO, Item.class);

        return item;
    }
}
