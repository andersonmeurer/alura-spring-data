package br.com.alura.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.ICargoRepository;
import br.com.alura.springdata.repository.IFuncionarioRepository;

@Service
public class RelatorioService {
	private final IFuncionarioRepository repository;

	public RelatorioService(IFuncionarioRepository repository) {
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {

		boolean continuar = true;
		do {
			System.out.println("Relatorio -> Qual opcao voce deseja executar");
			System.out.println("0 - Exit");
			System.out.println("1 - Busca funcionario nome");

			int action = scanner.nextInt();

			switch (action) {
			case 1: buscaFuncionarioNome(scanner);	break;
			default: continuar = false;				break;
			}
		} while (continuar);
	}

	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar:");
		List<Funcionario> list = repository.findByNome(scanner.next());
		list.forEach(System.out::println);
	}
}