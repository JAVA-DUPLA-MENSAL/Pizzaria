package br.com.projeto.pizzaria;

import br.com.projeto.pizzaria.controller.LoginController;
import br.com.projeto.pizzaria.controller.UsuarioController;
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
	private UsuarioService usuarioService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private SaboresService saboresService;

	@Autowired
	private EnderecoService enderecoService;

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
		var data = usuarioService.criar(new UsuarioDTO(1L,"Andre","123123123","800.123.123-22"));

		Assert.assertEquals("Andre", data.getNome());

	}

	@Test
	void editarUsuario(){
		var data = usuarioService.editar(1L,new UsuarioDTO(1L,"Carlos","123123123","800.123.123-22"));

		Assert.assertEquals("Carlos",data.getNome());
	}

	@Test
	void deletarUsuario(){
		String data = usuarioService.deletar(1L);

		Assert.assertEquals("usuario deletado",data);
	}

	//--------------------------PEDIDO------------------------------------//

	@Test
	void criarProduto(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Pizza","Nenhuma observacao",usuarioDTO);

		var data = pedidoService.criar(pedidoDTO);

		Assert.assertEquals("Pizza", data.getNome());
	}

	@Test
	void editarProduto(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Hamburguer","Nenhuma observacao",usuarioDTO);

		var data = pedidoService.editar(1L, pedidoDTO);

		Assert.assertEquals("Hamburguer",data.getNome());
	}

	@Test
	void deletarPedido(){
		var data = pedidoService.deletar(1L);

		Assert.assertEquals("Pedido deletado", data);
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

		var data = itemService.criar(itemDTO);

		Assert.assertEquals("Grande",itemDTO.getTamanho());
	}

	@Test
	void editarItem(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");
		PedidoDTO pedidoDTO = new PedidoDTO(1L,"Pizza","Nenhuma observacao",usuarioDTO);
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Calabresa");

		List<SaboresDTO> saboresDTOList = new ArrayList<>();
		saboresDTOList.add(saboresDTO);

		ItemDTO itemDTO = new ItemDTO(1L,pedidoDTO,"Pequeno",true,saboresDTOList);

		var data = itemService.editar(1L,itemDTO);

		Assert.assertEquals("Pequeno",itemDTO.getTamanho());
	}

	@Test
	void deletarItem(){
		var data = itemService.deletar(1L);

		Assert.assertEquals("Item deletado", data);
	}

	//-------------------SABORES-------------------//

	@Test
	void criarSabores(){
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Calabresa");

		var data = saboresService.criar(saboresDTO);

		Assert.assertEquals("Calabresa",data.getNome());

	}

	@Test
	void editarSabores(){
		SaboresDTO saboresDTO = new SaboresDTO(1L, "Portuguesa");

		var data = saboresService.editar(1L,saboresDTO);

		Assert.assertEquals("Portuguesa",data.getNome());
	}

	@Test
	void deletarSabores(){
		var data = saboresService.deletar(1L);

		Assert.assertEquals("Sabor deletado",data);
	}

	//------------------Endereco---------------------//

	@Test
	void criarEndereco(){
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L,"Andre","123123123","800.123.123-22");

		EnderecoDTO endereco = new EnderecoDTO(1L, "Av.Brasil",123,usuarioDTO);

		var data = enderecoService.criar(endereco);

		Assert.assertEquals("Av.Brasil",data.getRua());
	}



}
