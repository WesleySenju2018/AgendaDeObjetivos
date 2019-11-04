package br.com.bandtec.AgendaDeObjetivos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Credenciais credenciais;
	
	@OneToMany(mappedBy="usuario")
	private List<Objetivo> objetivos;
	
	private String nome;
	
	private Integer idade;

	public String getNome() {
		return nome;
	}
	public Usuario(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	
}
