package br.com.bandtec.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.bookstore.domain.Livro;
import br.com.bandtec.bookstore.service.LivroService;

@RestController
public class LivroController {

	private LivroService service;

	@Autowired
	public LivroController(LivroService service) {
		this.service = service;
	}

	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> obterPorTema(@PathVariable("tema") String tema) {
		List<Livro> livros = service.buscarPorTema(tema);
		if (livros.isEmpty()) {
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.ok(livros);
		}
	}

}
