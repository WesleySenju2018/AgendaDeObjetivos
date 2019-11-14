package br.com.bandtec.AgendaDeObjetivos.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bandtec.AgendaDeObjetivos.model.Livro;
import br.com.bandtec.AgendaDeObjetivos.model.Opiniao;

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

	public String casdatrarOpiniao(Opiniao opiniao) {
		String url = "http://localhost:8081/livros/opiniao";
		ResponseEntity<String> resposta = restTemplate.postForEntity(url, opiniao, String.class);
		return resposta.getBody();
	}

	public List<Opiniao> lerTodasOpinioes() {
		String url = "http://localhost:8081/livros/opinioes";
		ResponseEntity<Opiniao[]> todasOpinioes = restTemplate.getForEntity(url, Opiniao[].class);
		return Arrays.asList(todasOpinioes.getBody());
	}

	
}
