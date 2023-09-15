package br.com.projeto.pizzaria.controller;

import br.com.projeto.pizzaria.dto.PedidoDTO;
import br.com.projeto.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoDTO pedidoDTO){
        try{
            return ResponseEntity.ok(pedidoService.criar(pedidoDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PedidoDTO>> buscarTodos(){
        try{
            return ResponseEntity.ok(pedidoService.findAllPedido());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PedidoDTO> buscarId(@RequestParam("id")Long id){
        try{
            return ResponseEntity.ok(pedidoService.findById(id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestParam("id")Long id, @RequestBody PedidoDTO pedidoDTO){
        try{
            return ResponseEntity.ok(pedidoService.editar(id,pedidoDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@RequestParam("id") Long id){
        try{
            return ResponseEntity.ok(pedidoService.deletar(id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
