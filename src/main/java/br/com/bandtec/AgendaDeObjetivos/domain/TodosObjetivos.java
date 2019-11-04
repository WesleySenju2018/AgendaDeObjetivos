package br.com.bandtec.AgendaDeObjetivos.domain;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosObjetivos extends JpaRepository<Objetivo, Long>{
	
	//Objetivo == a classe e não TABELA!!!
	@Query("select o from Objetivo o where o.dataMaximaParaExecucao <= :data")
	public List<Objetivo> ate(@Param("data") LocalDate data);
	
}
