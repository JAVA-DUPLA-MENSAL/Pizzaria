package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.entity.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    public EnderecoDTO toEnderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO1 = new EnderecoDTO();

        enderecoDTO1.setRua(endereco.getRua());
        enderecoDTO1.setNumCasa(endereco.getNumCasa());

        return enderecoDTO1;
    }

    public Endereco toEnderecoDTO(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();

        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumCasa(enderecoDTO.getNumCasa());

        return endereco;
    }
}
