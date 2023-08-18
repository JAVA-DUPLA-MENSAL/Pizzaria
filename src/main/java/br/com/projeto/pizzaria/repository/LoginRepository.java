package br.com.projeto.pizzaria.repository;

import br.com.projeto.pizzaria.entity.Login;
import br.com.projeto.pizzaria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query(value = "SELECT p FROM Usuario p WHERE p.nome = :nome")
    List<Usuario> findByNameLogin(@Param("nome")final String nome);

    @Query(value = "SELECT p FROM Login p WHERE p.nome = :nome")
    List<Login> findByName(@Param("nome")final String nome);
}
