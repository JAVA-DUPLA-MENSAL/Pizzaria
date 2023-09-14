package br.com.projeto.pizzaria.controller;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import br.com.projeto.pizzaria.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping("/criar")
    public ResponseEntity<EnderecoDTO> criar(@RequestBody final EnderecoDTO enderecoDTO){
        try{
            return  ResponseEntity.ok(enderecoService.criar(enderecoDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecos(){
        try{
           return ResponseEntity.ok(enderecoService.findAllEnderecos());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestParam("id") Long id,@RequestBody EnderecoDTO enderecoDTO){
        try{
            enderecoService.editar(id,enderecoDTO);
            return ResponseEntity.ok(enderecoDTO.getUsuario() + " Foi alterado");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@RequestParam("id")Long id){
        try{
            enderecoService.deletar(id);
            return ResponseEntity.ok("Usuario deletado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
