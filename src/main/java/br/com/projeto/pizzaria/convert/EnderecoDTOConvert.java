package br.com.projeto.pizzaria.convert;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import br.com.projeto.pizzaria.entity.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDTOConvert extends UsuarioDTOConvert{

    @Autowired
    private ModelMapper modelMapper;


    public EnderecoDTO convertEnderecoToEnderecoDTO(Endereco endereco){
        convertUsuarioToUsuarioDTO(endereco.getUsuario());

        EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);

        return enderecoDTO;
    }

    public Endereco convertEnderecoDTOtoEndereco(EnderecoDTO enderecoDTO){
        convertUsuarioDTOToUsuario(enderecoDTO.getUsuario());

        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);

        return endereco;
    }


}
