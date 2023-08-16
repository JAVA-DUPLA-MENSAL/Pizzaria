package br.com.projeto.pizzaria.repository;

import br.com.projeto.pizzaria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
