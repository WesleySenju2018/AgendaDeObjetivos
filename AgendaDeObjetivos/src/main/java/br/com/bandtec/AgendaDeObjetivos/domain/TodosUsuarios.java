package br.com.bandtec.AgendaDeObjetivos.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios  extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.credenciais = :credenciais")
	public Usuario existe(@Param("credenciais") Credenciais credenciais);
	
}
