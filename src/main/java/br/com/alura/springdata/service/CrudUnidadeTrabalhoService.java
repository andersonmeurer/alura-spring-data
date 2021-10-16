package br.com.alura.springdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.IUnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final IUnidadeTrabalhoRepository repository;

	public CrudUnidadeTrabalhoService(IUnidadeTrabalhoRepository r) {
		this.repository = r;
	}

	public void inicial(Scanner scanner) {

		boolean continuar = true;
		do {
			System.out.println("Unidade de Trabalho -> Qual opcao voce deseja executar");
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
		UnidadeTrabalho obj = repository.findById(id).get();
		repository.deleteById(id);
		System.out.println(obj.getDescricao() + " Deletado!");
	}

	private void insert(Scanner scanner) {

		UnidadeTrabalho obj = new UnidadeTrabalho();
		System.out.println("Descricao da Unidade de Trabanho:");
		obj.setDescricao(scanner.next());
		System.out.println("Endereco:");
		obj.setEndereco(scanner.next());
		
		repository.save(obj);
		System.out.println(obj.getDescricao() + " Salvo!");
	}

	private void update(Scanner scanner) {

		System.out.println("Id");
		Integer id = scanner.nextInt();

		System.out.println("Descricao da Unidade de Trabanho");
		String descricao = scanner.next();

		UnidadeTrabalho obj = new UnidadeTrabalho();
		obj.setId(id);
		obj.setDescricao(descricao);
		repository.save(obj);
		System.out.println(obj.getDescricao() + " Atualizado!");
	}
	
	private void showAll() {
		Iterable<UnidadeTrabalho> list = repository.findAll();
		list.forEach(o -> System.out.println(o));
	}
	
	public List<UnidadeTrabalho> unidade(Scanner scanner) {
        List<UnidadeTrabalho> unidades = new ArrayList<>();

        while (true) {
            System.out.println("Digite o unidadeId (Para sair digite 0)");
            Integer unidadeId = scanner.nextInt();

            if(unidadeId == 0) {
            	break;
            }
            Optional<UnidadeTrabalho> unidade = repository.findById(unidadeId);
            unidades.add(unidade.get());
        }

        return unidades;
    }
}
