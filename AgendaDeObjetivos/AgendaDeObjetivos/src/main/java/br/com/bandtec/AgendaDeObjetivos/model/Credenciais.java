package br.com.bandtec.AgendaDeObjetivos.model;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {
		private String login;
		private String senha;
				
		public Credenciais(String login, String senha) {
			this.login = login;
			this.senha = senha;
		}
		public String getLogin() {
			// TODO Auto-generated method stub
			return login;
		}
		public String getSenha() {
			// TODO Auto-generated method stub
			return senha;
		}

}
