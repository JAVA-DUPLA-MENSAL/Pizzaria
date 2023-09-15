package br.com.projeto.pizzaria;

import br.com.projeto.pizzaria.controller.LoginController;
import br.com.projeto.pizzaria.entity.Login;
import br.com.projeto.pizzaria.entity.Usuario;
import br.com.projeto.pizzaria.repository.LoginRepository;
import br.com.projeto.pizzaria.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PizzariaApplicationTests {

	@MockBean
	LoginRepository loginRepository;

	@Autowired
	private LoginController loginController;

	@Autowired
	private LoginService loginService;

	@BeforeEach
	void injectData(){
		Usuario usuario = new Usuario();

		Login loginNew = new Login(1L,"admin@admin.com","senha",new Usuario(1L,"andre","123123","800.123.123-22"));
		usuario.setLogin(loginNew);

		Mockito.when(loginRepository.save(loginNew)).thenReturn(loginNew);

	}

//	@Test
//	void contextLoads() {
//		UsuarioDTO usuario = new UsuarioDTO(1L,"andre","123123","800.123.123-22");
//		LoginDTO loginNew = new LoginDTO(1L,"admin@admin.com","senha",usuario);
//
//		var data = loginService.criar(loginNew);
//
//		Assert.assertTrue(data.getEmail().equals("admin@admin.com"));
//
//	}

}
