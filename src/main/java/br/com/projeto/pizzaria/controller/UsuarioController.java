package br.com.projeto.pizzaria.controller;

import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> criar(@RequestBody UsuarioDTO usuarioDTO){
        try{
            usuarioService.criar(usuarioDTO);
            return ResponseEntity.ok("Usuario cadastrado");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
        try{
            return ResponseEntity.ok(usuarioService.findAllUsuarios());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
