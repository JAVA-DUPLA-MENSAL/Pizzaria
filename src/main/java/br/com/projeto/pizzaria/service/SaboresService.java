package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.SaboresDTO;
import br.com.projeto.pizzaria.entity.Sabores;
import br.com.projeto.pizzaria.repository.SaboresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaboresService {

    @Autowired
    private SaboresRepository saboresRepository;

    public SaboresDTO criar(SaboresDTO saboresDTO){
        Sabores sabores = this.saboresRepository.save(toSabores(saboresDTO));

        return toSaboresDTO(sabores);
    }

    public SaboresDTO findById(Long id){
        Sabores saboresBanco = saboresRepository.findById(id).orElse(null);

        return toSaboresDTO(saboresBanco);
    }

    public List<SaboresDTO> findAllSabores(){
        List<Sabores> saboresBanco = saboresRepository.findAll();
        List<SaboresDTO> saboresDTOList = new ArrayList<>();

        for(int i = 0; i < saboresBanco.size(); i++){
            saboresDTOList.add(toSaboresDTO(saboresBanco.get(i)));
        }

        return saboresDTOList;
    }

    public String editar(Long id, SaboresDTO saboresDTO){
        Sabores sabores = this.saboresRepository.findById(id).orElse(null);

        Assert.isTrue(sabores != null, "Sabor nao encontrado");

        this.saboresRepository.save(toSabores(saboresDTO));

        return saboresDTO.getNome() + "editado";
    }

    public String deletar(Long id){
        Sabores sabores = this.saboresRepository.findById(id).orElse(null);

        Assert.isTrue(sabores != null, "Sabor nao encontrado");

        this.saboresRepository.delete(sabores);

        return "Sabor deletado";
    }

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
