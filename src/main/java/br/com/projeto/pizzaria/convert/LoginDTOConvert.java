package br.com.projeto.pizzaria.convert;

import br.com.projeto.pizzaria.DTO.LoginDTO;
import br.com.projeto.pizzaria.entity.Login;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDTOConvert {

    @Autowired
    private ModelMapper modelMapper;

    public LoginDTO convertLoginTologinDTO(Login login){
        LoginDTO loginDTO = modelMapper.map(login, LoginDTO.class);

        return loginDTO;
    }


    public Login convertLoginDTOToLogin(LoginDTO loginDTO){
        Login login = modelMapper.map(loginDTO, Login.class);

        return login;
    }
}
