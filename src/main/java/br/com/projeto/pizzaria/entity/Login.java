package br.com.projeto.pizzaria.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id")
    private Usuario usuario;
}
