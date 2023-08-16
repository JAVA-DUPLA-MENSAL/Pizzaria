package br.com.projeto.pizzaria.DTO;

import br.com.projeto.pizzaria.entity.Usuario;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

   // private Long id;

    private String rua;

    private int numCasa;

    private Usuario usuario;

    public EnderecoDTO(){

    }

    public EnderecoDTO(String rua, int numCasa, Usuario usuarioDTO){
        this.rua=rua;
        this.numCasa=numCasa;
        this.usuario=usuarioDTO;
    }

}
