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
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO usuarioDTO){
        try{
            return ResponseEntity.ok( usuarioService.criar(usuarioDTO));
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

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<UsuarioDTO>> buscarNome(@RequestParam("nome")String nome){
        try{
            return ResponseEntity.ok(usuarioService.findByNome(nome));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestParam("id")Long id,@RequestBody UsuarioDTO  usuarioDTO){
        try{
           return ResponseEntity.ok(usuarioService.editar(id,usuarioDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@RequestParam("id")Long id){
        try{
           return ResponseEntity.ok(usuarioService.deletar(id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
