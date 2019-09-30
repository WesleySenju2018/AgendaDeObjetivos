package br.com.bandtec.AgendaDeObjetivos.domain;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "objetivos")
public class Objetivo {
	
	@Id
	@GeneratedValue
	@JsonProperty
	private Long id;
	
	@Embedded
	private Prioridade prioridade;
	
	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String descricao;
	
	@JsonProperty
	@Column(name = "data_maxia_para_execucao")
	private LocalDate dataMaximaParaExecucao;
	
	public Objetivo() {}
	
	public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	/*
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}*/
	
	
	public static boolean validar(Objetivo objetoAvaliado) {
		return 	objetoAvaliado.titulo != null &&
				objetoAvaliado.descricao != null &&
				objetoAvaliado.dataMaximaParaExecucao != null;
	}
	
}
