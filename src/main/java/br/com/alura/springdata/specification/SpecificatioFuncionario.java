package br.com.alura.springdata.specification;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.springdata.orm.Funcionario;

public class SpecificatioFuncionario {

	public static Specification<Funcionario> nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}

	public static Specification<Funcionario> cpf(String nome) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("cpf"), nome);
	}

	public static Specification<Funcionario> salario(Double salario) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("salario"), salario);
	}

	public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("dtContratacao"), dataContratacao);
	}
}