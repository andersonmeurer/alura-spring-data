package br.com.alura.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Cargo;

@Repository
public interface ICargoRepository extends CrudRepository<Cargo, Integer> {

}
