package br.com.projeto.pizzaria.entity;

import br.com.projeto.pizzaria.DTO.EnderecoDTO;
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

    @OneToMany
    private List<Endereco> enderecos;

    @OneToOne(mappedBy = "usuario")
    private Login login;
}
