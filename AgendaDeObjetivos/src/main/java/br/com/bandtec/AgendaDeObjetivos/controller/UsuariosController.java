package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.com.bandtec.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;

@RestController
public class UsuariosController {

	private TodosUsuarios listaUsuarios;
	
	@Autowired
	public UsuariosController(TodosUsuarios listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
//	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
//	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nomeProcurado){		
//		List<Usuario> usuariosPorNome = listaUsuarios.obterPorNome(nomeProcurado);
//				
//		if (usuariosPorNome.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		return ResponseEntity.ok(usuariosPorNome);
//	}
//	
//	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
//	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idadeProcurada){		
//		List<Usuario> usuariosPorIdade = listaUsuarios.obterPorIdade(idadeProcurada);
//		
//		if (usuariosPorIdade.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		return ResponseEntity.ok(usuariosPorIdade);
//	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario novoUsuario){
		listaUsuarios.save(novoUsuario);
		return ResponseEntity.ok(novoUsuario);
	}
		
}
