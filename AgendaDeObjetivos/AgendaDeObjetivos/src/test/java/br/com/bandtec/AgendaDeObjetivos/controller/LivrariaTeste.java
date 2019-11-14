 package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.bandtec.AgendaDeObjetivos.model.Opiniao;
import br.com.bandtec.AgendaDeObjetivos.service.LivrariaService;
import junit.framework.Assert;

public class LivrariaTeste {
	private LivrariaService service;
	
	@Before
	public void setUp() {
		service = new LivrariaService();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void listarOpinioes() {
		List<Opiniao> opinioes = service.lerTodasOpinioes();
		if(opinioes == null || opinioes.isEmpty()) {
			Assert.fail("Não tem nenhuma opinião cadastrada ainda. Ou a conexão com o microserviço não está funcionando");
		}
		else {
			for(Opiniao opiniao : opinioes) {
				String nome = opiniao.getNome();
				String texto = opiniao.getTexto();
				
				assertNotNull(nome);
				assertNotNull(texto);
			}
		}
	}
}
