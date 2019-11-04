package br.com.bandtec.AgendaDeObjetivos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bandtec.AgendaDeObjetivos.model.Livro;

@Service
public class LivrariaService {

	private RestTemplate restTemplate;

	public LivrariaService() {
		this.restTemplate = new RestTemplate();
	}

	public List<Livro> buscarPorTema(String tema) {
		String url = "http://localhost:8081/livros/tema/";
		String urlBusca = url + tema;
		ResponseEntity<List> resposta = restTemplate.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}
}
