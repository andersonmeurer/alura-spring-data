package br.com.alura.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;

@Repository
public interface IFuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {

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

	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}