package br.com.projeto.pizzaria.repository;

import br.com.projeto.pizzaria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
