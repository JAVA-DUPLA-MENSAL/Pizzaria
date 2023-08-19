package br.com.projeto.pizzaria.entity;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "CPF")
    private String CPF;


    //@Column(name = "endereco_fk")
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;

    @OneToOne(mappedBy = "usuario")
    private Login login;
}
