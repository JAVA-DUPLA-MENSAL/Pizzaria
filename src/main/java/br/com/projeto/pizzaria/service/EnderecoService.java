package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import br.com.projeto.pizzaria.convert.EnderecoDTOConvert;
import br.com.projeto.pizzaria.entity.Endereco;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoDTOConvert enderecoDTOConvert;


    public EnderecoDTO criar(EnderecoDTO enderecoDTO){
        Endereco enderecoTemp = enderecoDTOConvert.convertEnderecoDTOtoEndereco(enderecoDTO);

        Endereco endereco = this.enderecoRepository.save(enderecoTemp);

        return enderecoDTOConvert.convertEnderecoToEnderecoDTO(endereco);

    }

    public List<EnderecoDTO> findAllEnderecos(){
        List<Endereco> enderecosBanco = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();

        for(int i = 0; i < enderecosBanco.size(); i++){
            enderecoDTOList.add(enderecoDTOConvert.convertEnderecoToEnderecoDTO(enderecosBanco.get(i)));
        }

        return enderecoDTOList;
    }

    public String editar(Long id,EnderecoDTO enderecoDTO){
        Endereco enderecoBanco = enderecoRepository.findById(id).orElse(null);

        Assert.isTrue(enderecoBanco != null, "Endereco nao encontrado");
        enderecoRepository.save(enderecoDTOConvert.convertEnderecoDTOtoEndereco(enderecoDTO));
        return enderecoDTO.getUsuario().getNome() + " Editado com sucesso";
    }

    public String deletar(Long id){
        Endereco enderecoBanco = this.enderecoRepository.findById(id).orElse(null);

        Assert.isTrue(enderecoBanco != null, "Endereco nao encontrado");
        enderecoRepository.delete(enderecoBanco);

        return "Usuario deletado";
    }

}
