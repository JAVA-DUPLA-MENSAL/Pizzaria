package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criar(UsuarioDTO usuarioDTO){
        this.usuarioRepository.save(toUsuario(usuarioDTO));

    }

    public List<UsuarioDTO> findAllUsuarios(){
        List<Usuario> usuariosBanco = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        for(int i = 0; i < usuariosBanco.size(); i++){
            usuarioDTOList.add(toUsuarioDTO(usuariosBanco.get(i)));
        }

        return usuarioDTOList;
    }

    public String editar(Long id,UsuarioDTO usuarioDTO){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);

        Assert.isTrue(usuarioBanco != null, "Usuario nao encontrado");
        usuarioRepository.save(toUsuario(usuarioDTO));

        return usuarioDTO.getNome() + " editado com sucesso";
    }

    public String deletar(Long id){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);

        Assert.isTrue(usuarioBanco != null, "Usuario nao encontrado");
        usuarioRepository.delete(usuarioBanco);

        return "usuario deletado";
    }

    public Usuario toUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();

        usuario.setCPF(usuarioDTO.getCPF());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setEnderecos(usuarioDTO.getEnderecos());
        return usuario;
    }

    public UsuarioDTO toUsuarioDTO(Usuario usuario){

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setCPF(usuario.getCPF());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setEnderecos(usuario.getEnderecos());

        return usuarioDTO;
    }
}
