package br.com.projeto.pizzaria.entity;

import br.com.projeto.pizzaria.DTO.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Rua nao pode ser nulo")
    @Column(name = "rua")
    private String rua;

    @NotNull(message = "Numero da casa nao pode ser nulo")
    @Column(name = "num_casa")
    private int numCasa;


    @JsonIgnoreProperties("enderecos")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "Usuario nao pode ser nulo")
    private Usuario usuario;

    public Endereco(){

    }


}
