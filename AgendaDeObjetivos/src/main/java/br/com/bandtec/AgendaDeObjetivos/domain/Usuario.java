package br.com.bandtec.AgendaDeObjetivos.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	@JsonProperty
	private Long id;
	
	@Embedded
	private Credenciais credenciais;
	
//	@Column(name="login")
//	@JsonProperty
//	private String login;
//	
//	@Column(name="senha")
//	@JsonProperty
//	private String senha;
	
	public Usuario() {}
	
//	public Usuario(String login, String senha) {
//		this.login = login;
//		this.senha = senha;
//	}
//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
	
}
