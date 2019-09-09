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
public class ObjetivoController {

	public TodosObjetivos todosObj;

	@Autowired
	public ObjetivoController(TodosObjetivos todosObj) {
		this.todosObj = todosObj;
	}

	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastraObjetivo(@RequestBody Objetivo obj) {

		this.todosObj.save(obj);

		return ResponseEntity.ok("Sucesso");
	}

	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> bucarPorData(@PathVariable("data") String dataString) {

		LocalDate data = LocalDate.parse(dataString);

		List<Objetivo> objetivo = this.todosObj.ate(data);

		if (objetivo.isEmpty()) {

			return ResponseEntity.noContent().build();

		}

		return ResponseEntity.ok(objetivo);
	}
}