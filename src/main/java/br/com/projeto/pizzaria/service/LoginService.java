package br.com.projeto.pizzaria.service;

import br.com.projeto.pizzaria.DTO.LoginDTO;
import br.com.projeto.pizzaria.entity.Login;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginDTO criar(LoginDTO loginDTO){

        Login login = loginRepository.save(toLogin(loginDTO));

        return toLoginDTO(login);
    }


    public List<LoginDTO> buscarTodos(){
        List<Login> loginListBanco = loginRepository.findAll();
        List<LoginDTO> loginDTOList = new ArrayList<>();

        for(int i = 0; i< loginListBanco.size(); i++){
            loginDTOList.add(toLoginDTO(loginListBanco.get(i)));
        }

        return loginDTOList;
    }

    public List<LoginDTO> findByNome(String nome){
        List<Login> loginList = loginRepository.findByName(nome);
        List<LoginDTO> loginDTOList = new ArrayList<>();

        for(int i = 0; i < loginList.size(); i++){
            loginDTOList.add(toLoginDTO(loginList.get(i)));
        }
        return loginDTOList;
    }


    public Login toLogin(LoginDTO loginDTO){
        Login login = new Login();

        login.setEmail(loginDTO.getEmail());
        login.setSenha(loginDTO.getSenha());
        login.setUsuario(loginDTO.getUsuario());

        return login;
    }

    public LoginDTO toLoginDTO(Login login){
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail(login.getEmail());
        loginDTO.setSenha(login.getSenha());
        loginDTO.setUsuario(login.getUsuario());

        return loginDTO;
    }


}