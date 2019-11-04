package br.com.bandtec.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bandtec.bookstore.domain.Livro;

@Service
public class LivroService {
	
	public List<Livro> buscarPorTema(String tema){
		List<Livro> resultados = new ArrayList<Livro>();
		for (Livro livro : todosLivros()) {
			if(livro.comTema(tema)) {
				resultados .add(livro);
			}
		}
		return resultados;
	}
	
	private List<Livro> todosLivros(){
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro("50 tons de Livro","comedia"));
		livros.add(new Livro("A Morte do JS","religiao"));
		livros.add(new Livro("Kotlin ou java","TI"));
		livros.add(new Livro("Palmeiras a espera de um Mundial","comedia"));

		return livros;

	}
	
}
