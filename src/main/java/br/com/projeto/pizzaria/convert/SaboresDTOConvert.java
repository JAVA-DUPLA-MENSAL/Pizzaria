package br.com.projeto.pizzaria.convert;

import br.com.projeto.pizzaria.DTO.SaboresDTO;
import br.com.projeto.pizzaria.entity.Sabores;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaboresDTOConvert {

    @Autowired
    private ModelMapper modelMapper;

    public SaboresDTO convertSaboresToSaboresDTO(Sabores sabores){
        SaboresDTO saboresDTO = modelMapper.map(sabores, SaboresDTO.class);

        return saboresDTO;
    }

    public Sabores convertSaboresDTOToSabores(SaboresDTO saboresDTO){
        Sabores sabores = modelMapper.map(saboresDTO, Sabores.class);

        return sabores;
    }
}
