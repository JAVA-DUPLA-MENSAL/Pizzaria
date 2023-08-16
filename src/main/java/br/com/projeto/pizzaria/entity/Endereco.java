package br.com.projeto.pizzaria.entity;

import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "num_casa")
    private int numCasa;

    @ManyToOne
    @JoinColumn(name = "endereco_fk")
    private Usuario usuario;

    public Endereco(){

    }


}
