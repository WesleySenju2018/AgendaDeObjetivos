package br.com.bandtec.AgendaDeObjetivos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="objetivos")
public class Objetivo {

	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty
	@Column(name="titulo")
	private String titulo;
	
	@JsonProperty
	@Column(name="descricao")
	private String descricao;
	
	@JsonProperty
	@Column(name="data_maxima_para_execucao")
	private LocalDate dataMaximaParaExecucao;
	
	@Embedded
	private Prioridade prioridade;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Objetivo() {}
	
	public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao, Prioridade prioridade) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	public String getTitulo() {
		return titulo;
	}

//	public void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}

	public String getDescricao() {
		return descricao;
	}

//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}

//	public void setDataMaximaParaExecucao(LocalDate dataMaximaParaExecucao) {
//		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
//	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

//	public void setPrioridade(Prioridade prioridade) {
//		this.prioridade = prioridade;
//	}
	
	

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
}