package br.com.bandtec.AgendaDeObjetivos.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Prioridade {
	
	private String nome;
	private String observacoes;
	
	protected Prioridade() {}

	public Prioridade(String nome, String observacoes) {
		super();
		this.nome = nome;
		this.observacoes = observacoes;
	}

	public String getNome() {
		return nome;
	}

	public String getObservacoes() {
		return observacoes;
	}

}
