package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class UsuariosController {

	private List<Usuario> usuarios;

	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}

	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome) {
		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
		for (Usuario u : usuarios) {
			if (u.getNome().equals(nome)) {
				usuariosPorNome.add(u);
			}
		}

		if (usuariosPorNome.isEmpty()) {

			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuariosPorNome);
	}

	private List<Usuario> obterTodosUsuarios() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		usuarios.add(new Usuario("Wesley", 19));
		usuarios.add(new Usuario("Brabo", 17));
		usuarios.add(new Usuario("joon", 21));
		/*
		 * return Arrays.asList(new Usuario("Wesley", 19), new Usuario("Henry", 1), new
		 * Usuario("Aline", 20));
		 */
		return usuarios;

	}

	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idade) {
		List<Usuario> usuariosPorIdade = new ArrayList<Usuario>();
		for (Usuario i : usuarios) {
			if (i.getIdade().equals(idade)) {
				usuariosPorIdade.add(i);

			}

		}

		if (usuariosPorIdade.isEmpty()) {

			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuariosPorIdade);
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		this.usuarios.add(usuario);
		return ResponseEntity.ok(usuario);
	}
}
