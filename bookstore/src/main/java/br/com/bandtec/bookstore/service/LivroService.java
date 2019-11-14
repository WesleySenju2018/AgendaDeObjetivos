package br.com.bandtec.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bandtec.bookstore.domain.Livro;
import br.com.bandtec.bookstore.domain.Opiniao;

@Service
public class LivroService {

	private List<Opiniao> opinioes = new ArrayList<Opiniao>();
	
	

	public List<Livro> buscarPorTema(String tema) {
		List<Livro> resultados = new ArrayList<Livro>();
		for (Livro livro : todosLivros()) {
			if (livro.comTema(tema)) {
				resultados.add(livro);
			}
		}
		return resultados;
	}

	private List<Livro> todosLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro("50 tons de Livro", "comedia"));
		livros.add(new Livro("A Morte do JS", "religiao"));
		livros.add(new Livro("Kotlin ou java", "TI"));
		livros.add(new Livro("Palmeiras a espera de um Mundial", "comedia"));

		return livros;

	}

	public void adcionarOpiniao(Opiniao opiniao) {
		opinioes.add(opiniao);

	}
	
	public List<Opiniao> lerTodasOpinioes(){
		List<Opiniao> todasOpinioes = opinioes;
		return todasOpinioes;
		
	}

}
