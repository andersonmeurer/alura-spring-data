package br.com.alura.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;

@Repository
public interface IFuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	List<Funcionario> findByNome(String nome);

	//JPQL Colocar o nome que são usados nas classes
	@Query("SELECT f "
			+ "FROM Funcionario f "
			+ "WHERE f.nome = :nome "
			+ "AND f.salario >= :salario "
			+ "AND f.dtContratacao = :dataContratacao")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate dataContratacao);

	@Query(value = "SELECT * FROM funcionarios f WHERE f.dt_contratacao >= :dataContratacao", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate dataContratacao);
	
	//	@Query(value = "SELECT * FROM funcionarios WHERE nome = 1?", nativeQuery = true)
//	List<Funcionario> name(String nome);
}
