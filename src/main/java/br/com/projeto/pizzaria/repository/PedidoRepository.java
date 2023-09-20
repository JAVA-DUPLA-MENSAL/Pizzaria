package br.com.projeto.pizzaria.repository;

import br.com.projeto.pizzaria.entity.Pedido;
import br.com.projeto.pizzaria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
