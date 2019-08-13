package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.ResponseEntity;

public class LoginController {

	public ResponseEntity<String> validarLogin(Credencias credencias) {
		return ResponseEntity.ok("Login efetuado com sucesso");

	}

}
