package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
	
	@Test
	public void LoginComSucesso() {

		LoginController controller = new LoginController();

		ResponseEntity<String> resposta = controller.validarLogin(new Credencias("login", "senha"));

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Login efetuado com sucesso", resposta.getBody());
	}

	public void LoginComFalha() {

	}

}
