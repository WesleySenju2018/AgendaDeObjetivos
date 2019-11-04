package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.model.Credenciais;
//import br.com.bandtec.AgendaDeObjetivos.model.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.model.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.model.Usuario;

@RestController
public class LoginController{
	
	private TodosUsuarios usuarios;
	
	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.usuarios = todosUsuarios;
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credencias) {
//		if(credencias.getSenha().equals(credencias.getLogin())) {
//			return ResponseEntity.ok("Login efetuado com sucesso");			
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("erro");
//		}
//	}
	
	@PostMapping("/login")
	public ResponseEntity<String> validacaoLogin(@RequestBody Credenciais credenciais) {
		Usuario usuarioAutenticado = usuarios.existe(credenciais);
		if(usuarioAutenticado == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado");
		}
		return ResponseEntity.ok("Usuário autenticado");
	}
	
	@PostMapping("cadastrar")
	public ResponseEntity<String> cadastrar(@RequestBody Usuario usuario) {
		usuarios.save(usuario);
		return ResponseEntity.ok("Cadastro realizado com sucesso");
	}
}
