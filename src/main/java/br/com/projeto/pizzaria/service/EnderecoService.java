package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.entity.Endereco;
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

    public void criar(EnderecoDTO enderecoDTO){
        //fazer validacoes antes de salvar

        this.enderecoRepository.save(toEndereco(enderecoDTO));
    }

    public List<EnderecoDTO> findAllEnderecos(){
        List<Endereco> enderecosBanco = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();

        for(int i = 0; i < enderecosBanco.size(); i++){
            enderecoDTOList.add(toEnderecoDTO(enderecosBanco.get(i)));
        }

        return enderecoDTOList;
    }

    public void editar(Long id,EnderecoDTO enderecoDTO){
        //fazer validacoes entes d esalvar
        Endereco enderecoBanco = this.enderecoRepository.findById(id).orElse(null);

        Assert.isTrue(enderecoBanco != null, "Endereco nao encontrado");
        this.enderecoRepository.save(toEndereco(enderecoDTO));
    }

    public void deletar(Long id){
        Endereco enderecoBanco = this.enderecoRepository.findById(id).orElse(null);

        Assert.isTrue(enderecoBanco != null, "Endereco nao encontrado");
        this.enderecoRepository.delete(enderecoBanco);
    }

    public EnderecoDTO toEnderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO1 = new EnderecoDTO();

        enderecoDTO1.setId(endereco.getId());
        enderecoDTO1.setRua(endereco.getRua());
        enderecoDTO1.setNumCasa(endereco.getNumCasa());
        enderecoDTO1.setUsuario(endereco.getUsuario());

        return enderecoDTO1;
    }

    public Endereco toEndereco(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();
        endereco.setId(enderecoDTO.getId());
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumCasa(enderecoDTO.getNumCasa());
        endereco.setUsuario(enderecoDTO.getUsuario());
        return endereco;
    }
}
