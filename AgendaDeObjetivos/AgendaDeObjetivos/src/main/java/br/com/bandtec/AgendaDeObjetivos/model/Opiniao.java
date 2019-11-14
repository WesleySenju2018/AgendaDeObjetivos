package br.com.bandtec.AgendaDeObjetivos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Opiniao {
	
	
	@JsonProperty
	private String nome;

	@JsonProperty
	private String texto;

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	public String getTexto() {
		// TODO Auto-generated method stub
		return texto;
	}
}
