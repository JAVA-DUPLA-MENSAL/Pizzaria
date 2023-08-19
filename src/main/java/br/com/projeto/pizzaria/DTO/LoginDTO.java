package br.com.projeto.pizzaria.DTO;

import br.com.projeto.pizzaria.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    private Long id;

    private String email;

    private String senha;

    private Usuario usuario;

    public LoginDTO(){

    }

    public LoginDTO(Long id, String email, String senha, Usuario usuario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
    }
}
