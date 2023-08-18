package br.com.projeto.pizzaria.controller;

import br.com.projeto.pizzaria.DTO.LoginDTO;
import br.com.projeto.pizzaria.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LoginDTO> criar(@RequestBody LoginDTO loginDTO){
        try{
            return ResponseEntity.ok(loginService.criar(loginDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("/todos")
    public ResponseEntity<List<LoginDTO>> buscarTodos(){
        try{

        }catch (Exception e){

        }
    }

}
