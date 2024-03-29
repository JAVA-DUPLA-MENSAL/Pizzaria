package br.com.projeto.pizzaria.controller;

import br.com.projeto.pizzaria.dto.ItemDTO;
import br.com.projeto.pizzaria.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ItemDTO> criar(@RequestBody ItemDTO itemDTO){
        try{
            return ResponseEntity.ok(itemService.criar(itemDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ItemDTO>> buscarTodos(){
        try{
            return ResponseEntity.ok(itemService.findAllItens());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public  ResponseEntity<ItemDTO> buscarId(@RequestParam("id")Long id){
        try{
            return ResponseEntity.ok(itemService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ItemDTO> editar(@RequestParam("id")Long id, @RequestBody ItemDTO itemDTO){
        try{
            return ResponseEntity.ok(itemService.editar(id,itemDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@RequestParam("id") Long id){
        try{
            return ResponseEntity.ok(itemService.deletar(id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
