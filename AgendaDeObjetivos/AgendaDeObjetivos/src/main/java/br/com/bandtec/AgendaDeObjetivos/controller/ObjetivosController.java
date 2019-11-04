package br.com.bandtec.AgendaDeObjetivos.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.model.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.model.TodosObjetivos;

@RestController
public class ObjetivosController {
	private TodosObjetivos objetivos;
	
	@Autowired
	public ObjetivosController(TodosObjetivos todosObjetivos) {
		this.objetivos = todosObjetivos;
	}
	
	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastrarObjetivo(@RequestBody Objetivo objetivo) {
		this.objetivos.save(objetivo);
		return ResponseEntity.ok("Objetivo cadastrado com sucesso");
	}
	
	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> buscarObjetivoPorData(@PathVariable("data") String dataProcurada) {
		
		LocalDate data = LocalDate.parse(dataProcurada);
		List<Objetivo> objetivoData = objetivos.ate(data);
		if(objetivoData.isEmpty()) {
			return ResponseEntity.noContent().build(); //204 requisição feita com sucesso mas não foi encontrdo nada
		}
		
		return ResponseEntity.ok(objetivoData);
	}
}
