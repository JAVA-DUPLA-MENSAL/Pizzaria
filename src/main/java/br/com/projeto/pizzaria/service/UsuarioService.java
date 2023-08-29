package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.DTO.UsuarioDTO;
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

    public UsuarioDTO criar(UsuarioDTO usuarioDTO){

        System.out.println("1 "+usuarioDTO.getEnderecos().size());
        Usuario usuariotemp = toUsuario(usuarioDTO);
       Usuario usuario =  this.usuarioRepository.save(usuariotemp);
        System.out.println("2 " + usuariotemp.getEnderecos().size());

       return toUsuarioDTO(usuario);
    }

    public List<UsuarioDTO> findByNome(String nome){
        List<Usuario> usuarioBanco = this.usuarioRepository.findPessoaByNome(nome);
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        for(int i = 0; i < usuarioBanco.size(); i++){
            usuarioDTOList.add(toUsuarioDTO(usuarioBanco.get(i)));
        }

        return usuarioDTOList;
    }


    public List<UsuarioDTO> findAllUsuarios(){
        List<Usuario> usuariosBanco = usuarioRepository.findAllUsuarios();
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

        usuario.setId(usuarioDTO.getId());
        usuario.setCPF(usuarioDTO.getCPF());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setTelefone(usuarioDTO.getTelefone());

        List<Endereco> dump = new ArrayList<>();

        if(usuarioDTO.getEnderecos() != null){
            for(int i = 0; i < usuarioDTO.getEnderecos().size(); i++){
                Endereco aux = enderecoService.toEndereco(usuarioDTO.getEnderecos().get(i));
                aux.setUsuario(usuario);
                dump.add(aux);
                dump.forEach(e ->{
                    System.out.println(e.getId());
                });

            }
        }

        usuario.setEnderecos(dump);
        return usuario;
    }

    public UsuarioDTO toUsuarioDTO(Usuario usuario){

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setCPF(usuario.getCPF());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setTelefone(usuario.getTelefone());


        List<EnderecoDTO> dump = new ArrayList<>();

        if(usuario.getEnderecos() != null){
           for(int i =0; i < usuario.getEnderecos().size(); i++){
               dump.add(enderecoService.toEnderecoDTO(usuario.getEnderecos().get(i)));
           }
        }
        usuarioDTO.setEnderecos(dump);
        return usuarioDTO;
    }
}
