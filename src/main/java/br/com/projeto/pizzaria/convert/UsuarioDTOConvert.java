package br.com.projeto.pizzaria.convert;


import br.com.projeto.pizzaria.dto.UsuarioDTO;
import br.com.projeto.pizzaria.entity.Endereco;
import br.com.projeto.pizzaria.entity.Login;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.service.EnderecoService;
import br.com.projeto.pizzaria.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioDTOConvert {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EnderecoService enderecoService;

    public UsuarioDTO convertUsuarioToUsuarioDTO(Usuario usuario) {

        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);

        if (usuarioDTO.getEnderecos() != null) {
            for (int i = 0; i < usuarioDTO.getEnderecos().size(); i++) {
                usuarioDTO.getEnderecos().get(i).setUsuario(usuarioDTO);
            }

        }

        return usuarioDTO;
    }

    public Usuario convertUsuarioDTOToUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setCpf(usuarioDTO.getCpf());

        Login login = new Login();

        if(usuarioDTO.getLogin() != null) {
            login.setId(usuarioDTO.getLogin().getId());
            login.setEmail(usuarioDTO.getLogin().getEmail());
            login.setSenha(usuarioDTO.getLogin().getSenha());
            usuario.setLogin(login);
        }

        List<Endereco> lista = new ArrayList<>();
        if (usuarioDTO.getEnderecos() != null) {
            for (int i = 0; i < usuarioDTO.getEnderecos().size(); i++) {
                Endereco endereco = new Endereco();
                endereco.setId(usuarioDTO.getEnderecos().get(i).getId());
                endereco.setRua(usuarioDTO.getEnderecos().get(i).getRua());
                endereco.setNumCasa(usuarioDTO.getEnderecos().get(i).getNumCasa());
                endereco.setUsuario(usuario);
                lista.add(endereco);
            }

        }
        usuario.setEnderecos(lista);

        for(int i=0; i<usuario.getEnderecos().size(); i++){
           // usuario.getEnderecos().get(i).setUsuario(usuario);
        }


        return usuario;
    }

}
