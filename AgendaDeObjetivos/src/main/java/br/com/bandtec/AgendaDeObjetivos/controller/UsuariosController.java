package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import br.com.bandtec.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;

@RestController
public class UsuariosController {

	private TodosUsuarios todosUsuario;

	@Autowired
	public UsuariosController(TodosUsuarios todosUsuario) {
		this.todosUsuario = todosUsuario;
	}

	@GetMapping("/usuarios/nome/{nomeDoUsuario}")

	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nomeProcurado) {

		List<Usuario> usuariosPorNome = todosUsuario.porNome(nomeProcurado);

		if (usuariosPorNome.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuariosPorNome);
	}

	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idadeProcurada) {
		List<Usuario> usuariosPorIdade = todosUsuario.porIdade(idadeProcurada);

		if (usuariosPorIdade.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuariosPorIdade);
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario novoUsuario) {
		todosUsuario.save(novoUsuario);
		return ResponseEntity.ok(novoUsuario);
	}

}
