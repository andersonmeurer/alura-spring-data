package br.com.alura.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;

@Repository
public interface IFuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	List<Funcionario> findByNome(String nome);
	
	List<Funcionario> findByNomeIgnoreCaseIsLike(String nome);
	
//	@Query(value = "SELECT * FROM funcionarios WHERE nome = 1?", nativeQuery = true)
//	List<Funcionario> name(String nome);
}
