package br.com.bandtec.AgendaDeObjetivos.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.credenciais = :credenciais")
	public Usuario existe(@Param("credenciais") Credenciais credenciais);
	
//	public List<Usuario> findByNameAndIdade(String nome, Integer idade);
	
	@Query("select u from Usuario u where u.nome = :nome")
	public List<Usuario> findByName (String nome);
	
	@Query("select u from Usuario u where u.idade = :idade")
	public List<Usuario> findByIdade(@Param("idade") Integer idade);
}


