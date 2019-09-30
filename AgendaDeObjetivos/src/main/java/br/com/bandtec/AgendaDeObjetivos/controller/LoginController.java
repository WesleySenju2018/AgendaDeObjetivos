package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;

@RestController
public class LoginController {
	
	private TodosUsuarios todosUsuarios;
	
	@Autowired
	public LoginController(TodosUsuarios listaUsuarios) {
		this.todosUsuarios = listaUsuarios;
	}	
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastraUsuario(@RequestBody Usuario usuario){
		todosUsuarios.save(usuario);
		return ResponseEntity.ok("usuario cadastrado com sucesso");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUsuario(@RequestBody Credenciais usuario){
		
		Usuario usuarioAutentica = todosUsuarios.existe(usuario);
		if(usuarioAutentica == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("usuario não existe");
		}
		return ResponseEntity.ok("Usuario autenticado");
	}
}
