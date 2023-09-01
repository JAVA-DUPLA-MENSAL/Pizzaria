package br.com.projeto.pizzaria.convert;


import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import br.com.projeto.pizzaria.entity.Endereco;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.service.EnderecoService;
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

        //System.out.println("inico: " + usuario.getEnderecos().size());
        //List<EnderecoDTO> dump = new ArrayList<>();

        if (usuarioDTO.getEnderecos() != null) {
            for (int i = 0; i < usuarioDTO.getEnderecos().size(); i++) {
                //dump.add(enderecoService.toEnderecoDTO(usuario.getEnderecos().get(i)));
                usuarioDTO.getEnderecos().get(i).setUsuario(usuarioDTO);
            }

            //usuarioDTO.setEnderecos(dump);


        }


        return usuarioDTO;
    }

    public Usuario convertUsuarioDTOToUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);

        if (usuario.getEnderecos() != null) {
            for (int i = 0; i < usuario.getEnderecos().size(); i++) {
                //dump.add(enderecoService.toEnderecoDTO(usuario.getEnderecos().get(i)));
                usuario.getEnderecos().get(i).setUsuario(usuario);
            }

            //usuarioDTO.setEnderecos(dump);


        }



        return usuario;
    }

}
