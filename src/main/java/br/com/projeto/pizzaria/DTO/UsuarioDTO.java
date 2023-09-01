package br.com.projeto.pizzaria.DTO;

import br.com.projeto.pizzaria.entity.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String telefone;

    private String CPF;

    @JsonIgnoreProperties("usuario")
    private List<EnderecoDTO> enderecos;

    public UsuarioDTO(){

    }

    public UsuarioDTO( Long id, String nome, String telefone, String CPF, List<EnderecoDTO> enderecos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.CPF = CPF;
        this.enderecos = enderecos;
    }
}
