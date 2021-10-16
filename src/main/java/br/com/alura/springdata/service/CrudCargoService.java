package br.com.alura.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.ICargoRepository;

@Service
public class CrudCargoService {

	private final ICargoRepository repository;

	public CrudCargoService(ICargoRepository cargoRepository) {
		this.repository = cargoRepository;
	}

	public void inicial(Scanner scanner) {

		boolean continuar = true;
		do {
			System.out.println("Cargo -> Qual opcao voce deseja executar");
			System.out.println("0 - Exit");
			System.out.println("1 - Save");
			System.out.println("2 - Update");
			System.out.println("3 - Show All");
			System.out.println("4 - Delete");

			int action = scanner.nextInt();

			switch (action) {
				case 1: insert(scanner);		break;
				case 2: update(scanner);	break;
				case 3: showAll();			break;
				case 4: delete(scanner);	break;
				default: continuar = false;	break; 
			}
		} while (continuar);
	}

	private void delete(Scanner scanner) {
		System.out.println("Id");
		Integer id = scanner.nextInt();
		Cargo cargo = repository.findById(id).get();
		repository.deleteById(id);
		System.out.println(cargo.getDescricao() + " Deletado!");
	}

	private void insert(Scanner scanner) {
		Cargo cargo = new Cargo();
		System.out.println("Descricao do cargo:");
		cargo.setDescricao(scanner.next());
		repository.save(cargo);
		System.out.println(cargo.getDescricao() + " Salvo!");
	}

	private void update(Scanner scanner) {

		System.out.println("Id");
		Integer id = scanner.nextInt();

		System.out.println("Descricao do cargo");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		repository.save(cargo);
		System.out.println(cargo.getDescricao() + " Atualizado!");
	}
	
	private void showAll() {
		Iterable<Cargo> list = repository.findAll();
		list.forEach(c -> System.out.println(c));
	}
}
