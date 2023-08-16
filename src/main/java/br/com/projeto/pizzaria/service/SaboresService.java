package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.SaboresDTO;
import br.com.projeto.pizzaria.entity.Sabores;
import org.springframework.stereotype.Service;

@Service
public class SaboresService {

    public SaboresDTO toSaboresDTO(Sabores sabores){
        SaboresDTO saboresDTO = new SaboresDTO();

        saboresDTO.setNome(sabores.getNome());
        saboresDTO.setItem(sabores.getItem());
        saboresDTO.setId(sabores.getId());

        return saboresDTO;
    }

    public Sabores toSabores(SaboresDTO saboresDTO){
        Sabores sabores = new Sabores();

        sabores.setItem(saboresDTO.getItem());
        sabores.setNome(saboresDTO.getNome());
        sabores.setId(saboresDTO.getId());

        return sabores;
    }

}
