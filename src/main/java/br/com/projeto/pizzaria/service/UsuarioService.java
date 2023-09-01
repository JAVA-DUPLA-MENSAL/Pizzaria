package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import br.com.projeto.pizzaria.convert.UsuarioDTOConvert;
import br.com.projeto.pizzaria.entity.Endereco;
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

    @Autowired
    private  EnderecoService enderecoService;

    @Autowired
    private UsuarioDTOConvert usuarioDTOConvert;

    public UsuarioDTO criar(UsuarioDTO usuarioDTO){

        System.out.println("1 "+usuarioDTO.getEnderecos().size());
        //Usuario usuariotemp = toUsuario(usuarioDTO);
       Usuario usuariotemp = usuarioDTOConvert.convertUsuarioDTOToUsuario(usuarioDTO);

        Usuario usuario =  this.usuarioRepository.save(usuariotemp);
        System.out.println("2 " + usuariotemp.getEnderecos().size());

       return usuarioDTOConvert.convertUsuarioToUsuarioDTO(usuario);
    }

    public List<UsuarioDTO> findByNome(String nome){
        List<Usuario> usuarioBanco = this.usuarioRepository.findPessoaByNome(nome);
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        for(int i = 0; i < usuarioBanco.size(); i++){
            usuarioDTOList.add(usuarioDTOConvert.convertUsuarioToUsuarioDTO(usuarioBanco.get(i)));
        }

        return usuarioDTOList;
    }


    public List<UsuarioDTO> findAllUsuarios(){
        List<Usuario> usuariosBanco = usuarioRepository.findAllUsuarios();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        System.out.println("inicio " + usuariosBanco.size());

        for(int i = 0; i < usuariosBanco.size(); i++){
            usuarioDTOList.add(usuarioDTOConvert.convertUsuarioToUsuarioDTO(usuariosBanco.get(i)));
        }

        System.out.println("fim " + usuarioDTOList.size());

        return usuarioDTOList;
    }

    public String editar(Long id,UsuarioDTO usuarioDTO){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);

        Assert.isTrue(usuarioBanco != null, "Usuario nao encontrado");
        usuarioRepository.save(usuarioDTOConvert.convertUsuarioDTOToUsuario(usuarioDTO));

        return usuarioDTO.getNome() + " editado com sucesso";
    }

    public String deletar(Long id){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);

        Assert.isTrue(usuarioBanco != null, "Usuario nao encontrado");
        usuarioRepository.delete(usuarioBanco);

        return "usuario deletado";
    }

}
