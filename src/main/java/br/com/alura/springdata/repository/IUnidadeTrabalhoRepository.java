package br.com.alura.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.UnidadeTrabalho;

@Repository
public interface IUnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho, Integer> {

}
