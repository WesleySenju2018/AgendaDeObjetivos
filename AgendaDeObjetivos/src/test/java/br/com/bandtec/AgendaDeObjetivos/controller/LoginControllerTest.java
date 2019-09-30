package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bandtec.AgendaDeObjetivos.domain.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;

public class LoginControllerTest {

	private LoginController controller;
	private TodosUsuarios todosUsuarios;

	@Before
	public void setUp() {
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosUsuarios);
	}

	@Test
	public void loginComSucesso() {
		Credenciais c = new Credenciais("igual", "igual");
		Mockito.when(todosUsuarios.existe(c)).thenReturn(new Usuario());
		ResponseEntity<String> resposta = controller.loginUsuario(c);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sucesso", resposta.getBody());
	}

	@Test
	public void loginComFalha() {
		ResponseEntity<String> resposta = controller.loginUsuario(c)(new Credenciais("login", "senha"));
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("Erro", resposta.getBody());
	}

}
