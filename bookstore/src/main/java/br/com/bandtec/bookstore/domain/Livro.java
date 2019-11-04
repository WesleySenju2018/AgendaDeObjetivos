package br.com.bandtec.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Livro {
	
	@JsonProperty
	private String nome;
	@JsonProperty
	private String tema;
	
	public Livro(String nome, String tema) {
		this.nome = nome;
		this.tema = tema;
	}

	public boolean comTema(String tema) {
		
		return this.tema.equals(tema);
	}
}
