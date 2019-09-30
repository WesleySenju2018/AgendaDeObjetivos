package br.com.bandtec.AgendaDeObjetivos.controller;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.domain.TodosObjetivos;

@RestController
public class ObjetivoController {
	
//	public List<Objetivo> listaObjetivos;
	
	private TodosObjetivos listaObjetivos;
	
	@Autowired
	public ObjetivoController(TodosObjetivos todosObjetivos) {
		listaObjetivos = todosObjetivos;
	}
	
	
	@PostMapping("/objetivos")
	public ResponseEntity<Objetivo> cadastrarObjetivo(@RequestBody Objetivo novoObjetivo){
//		if (Objetivo.validar(novoObjetivo)) {
//			System.out.println("erro no cadastro");
//			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(novoObjetivo);
//		}
		
		listaObjetivos.save(novoObjetivo);
		return ResponseEntity.ok(novoObjetivo);
	}
	
	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> pesquisarPorData(@PathVariable("data") String dataProcurada){
		LocalDate data = LocalDate.parse(dataProcurada);		
		
		List<Objetivo> objetivosPorData = listaObjetivos.ate(data);
		
		if (objetivosPorData == null || objetivosPorData.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(objetivosPorData);
	}
	
	
}
