package br.com.alura.springdata.orm;

/*
 * Interface based Projection.
 * Como alternativa, podemos também usar uma classe DTO com o mesmo propósito
 */
public interface FuncionarioProjecao {

	Integer getId();

	String getNome();

	Double getSalario();

}