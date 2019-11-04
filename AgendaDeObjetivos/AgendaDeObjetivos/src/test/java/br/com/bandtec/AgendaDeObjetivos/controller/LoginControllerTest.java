package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bandtec.AgendaDeObjetivos.model.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.model.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.model.Usuario;

public class LoginControllerTest {
	
	private LoginController controller;
	private TodosUsuarios todosUsuarios;
	
	@Before
	public void setUp() {
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosUsuarios);
	}
	
	@Test
	public void LoginComSucesso() {
		Credenciais credenciais = new Credenciais("igual", "igual");
		Mockito.when(todosUsuarios.existe(credenciais)).thenReturn(new Usuario("nome", 40));
		ResponseEntity<String> resposta = controller.validacaoLogin(credenciais);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Usuário autenticado", resposta.getBody());
	}

	@Test
	public void LoginComFalha() {
		Credenciais c = new Credenciais("login", "senha");
		Mockito.when(todosUsuarios.existe(c)).thenReturn(null);
		ResponseEntity<String> resposta = controller.validacaoLogin(c);
		
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("Usuário não autenticado", resposta.getBody());		
	}
}