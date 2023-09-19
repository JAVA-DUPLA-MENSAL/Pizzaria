package br.com.projeto.pizzaria;

import br.com.projeto.pizzaria.controller.*;
import br.com.projeto.pizzaria.dto.*;
import br.com.projeto.pizzaria.entity.*;
import br.com.projeto.pizzaria.repository.*;
import br.com.projeto.pizzaria.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PizzariaApplicationTests {


	@MockBean
	UsuarioRepository usuarioRepository;

	@MockBean
	PedidoRepository pedidoRepository;

	@MockBean
	ItemRepository itemRepository;

	@MockBean
	SaboresRepository saboresRepository;

	@MockBean
	EnderecoRepository enderecoRepository;

	@Autowired
	private UsuarioController usuarioController;

	@Autowired
	private PedidoController pedidoController;

	@Autowired
	private ItemController itemController;

	@Autowired
	private SaboresController saboresController;

	@Autowired
	private EnderecoController enderecoController;

	@BeforeEach
	void injectData(){
		Usuario usuario = new Usuario(1L,"Andre","123123123","800.123.123-22");

		Endereco endereco = new Endereco(1L, "Av.Brasil",123,usuario);

		Pedido pedido = new Pedido(1L,"Pizza","Nenhuma observacao",usuario);

		Sabores sabores = new Sabores(1L, "Calabresa");

		List<Sabores> saboresList = new ArrayList<>();
		saboresList.add(sabores);

		Item item = new Item(1L,pedido,"Grande",true,saboresList);

		Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
		Mockito.when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

		Mockito.when(pedidoRepository.save(pedido)).thenReturn(pedido);
		Mockito.when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

		Mockito.when(itemRepository.save(item)).thenReturn(item);
		Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

		Mockito.when(saboresRepository.save(sabores)).thenReturn(sabores);
		Mockito.when(saboresRepository.findById(1L)).thenReturn(Optional.of(sabores));

		Mockito.when(enderecoRepository.save(endereco)).thenReturn(endereco);
		Mockito.when(enderecoRepository.findById(1L)).thenReturn(Optional.of(endereco));


	}

	@Test
	void criarUsuario() {
		var data = usuarioController.criar(new UsuarioDTO(1L,"Andre","123123123","800.123.123-22"));

		Assert.assertEquals("Andre", data.getBody().getNome());

	}

	@Test
	void editarUsuario(){
		var data = usuarioController.editar(1L,new UsuarioDTO(1L,"Carlos","123123123","800.123.123-22"));

		Assert.assertEquals("Carlos",data.getBody().getNome());
	}

	@Test
	void deletarUsuario(){
		var data = usuarioController.deletar(1L);

		Assert.assertEquals("usuario deletado",data.getBody());
	}

	//--------------------------PEDIDO------------------------------------//

	@Test
	void criarProduto(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Pizza","Nenhuma observacao",usuarioDTO);

		var data = pedidoController.criar(pedidoDTO);

		Assert.assertEquals("Pizza", data.getBody().getNome());
	}

	@Test
	void editarProduto(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Hamburguer","Nenhuma observacao",usuarioDTO);

		var data = pedidoController.editar(1L, pedidoDTO);

		Assert.assertEquals("Hamburguer",data.getBody().getNome());
	}

	@Test
	void deletarPedido(){
		var data = pedidoController.deletar(1L);

		Assert.assertEquals("Pedido deletado", data.getBody());
	}

	//--------------------ITEM-------------------------//

	@Test
	void criarItem(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Pizza","Nenhuma observacao",usuarioDTO);
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Calabresa");

		List<SaboresDTO> saboresDTOList = new ArrayList<>();
		saboresDTOList.add(saboresDTO);

		ItemDTO itemDTO = new ItemDTO(1L,pedidoDTO,"Grande",true,saboresDTOList);

		var data = itemController.criar(itemDTO);

		Assert.assertEquals("Grande",data.getBody().getTamanho());
	}

	@Test
	void editarItem(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Pizza","Nenhuma observacao",usuarioDTO);
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Calabresa");

		List<SaboresDTO> saboresDTOList = new ArrayList<>();
		saboresDTOList.add(saboresDTO);

		ItemDTO itemDTO = new ItemDTO(1L,pedidoDTO,"Pequeno",true,saboresDTOList);

		var data = itemController.editar(1L,itemDTO);

		Assert.assertEquals("Pequeno",data.getBody().getTamanho());
	}

	@Test
	void editarItemError(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Pizza","Nenhuma observacao",usuarioDTO);
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Calabresa");

		List<SaboresDTO> saboresDTOList = new ArrayList<>();
		saboresDTOList.add(saboresDTO);

		ItemDTO itemDTO = new ItemDTO(1L,pedidoDTO,"Pequeno",true,saboresDTOList);

		var data = itemController.editar(1L,itemDTO);

		Assert.assertEquals("Pequeno",data.getBody().getTamanho());
	}

	@Test
	void deletarItem(){
		var data = itemController.deletar(1L);

		Assert.assertEquals("Item deletado", data.getBody());
	}

	//-------------------SABORES-------------------//

	@Test
	void criarSabores(){
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Calabresa");

		var data = saboresController.criar(saboresDTO);

		Assert.assertEquals("Calabresa",data.getBody().getNome());

	}

	@Test
	void editarSabores(){
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Portuguesa");

		var data = saboresController.editar(1L,saboresDTO);

		Assert.assertEquals("Portuguesa",data.getBody().getNome());
	}

	@Test
	void deletarSabores(){
		var data = saboresController.deletar(1L);

		Assert.assertEquals("Sabor deletado",data.getBody());
	}

	//------------------Endereco---------------------//

	@Test
	void criarEndereco(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");

		EnderecoDTO endereco = new EnderecoDTO(1L, "Av.Brasil",123,usuarioDTO);

		var data = enderecoController.criar(endereco);

		Assert.assertEquals("Av.Brasil",data.getBody().getRua());
	}



}
