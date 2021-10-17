package br.com.alura.springdata.service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.ICargoRepository;
import br.com.alura.springdata.repository.IFuncionarioRepository;

@Service
public class RelatorioService {

	private final IFuncionarioRepository repository;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public RelatorioService(IFuncionarioRepository repository) {
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {

		boolean continuar = true;
		do {
			System.out.println("Relatorio -> Qual opcao voce deseja executar");
			System.out.println("0 - Exit");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario nome, data contratacao e salario maior");
			System.out.println("3 - Busca funcionario data contratacao");

			int action = scanner.nextInt();

			switch (action) {
				case 1: buscaFuncionarioNome(scanner);					break;
				case 2: findNomeSalarioMaiorDataContratacao(scanner);	break;
				case 3: findDataContratacaoMaior(scanner);				break;
				default: continuar = false;								break;
			}
		} while (continuar);
	}

	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar:");
		List<Funcionario> list = repository.findByNome(scanner.next());
		list.forEach(System.out::println);
	}
	
	private void findNomeSalarioMaiorDataContratacao(Scanner scanner) {
		Funcionario f = new Funcionario();

		System.out.println("Qual nome deseja pesquisar:");
		f.setNome(scanner.next());

		System.out.println("Qual salario deseja pesquisar:");
		f.setSalario(scanner.nextDouble());

		System.out.println("Qual data de contratacao deseja pesquisar (dd/MM/yyyy):");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		f.setDtContratacao(localDate);

		List<Funcionario> list = repository.findNomeSalarioMaiorDataContratacao(f.getNome(), f.getSalario(), f.getDtContratacao());
		list.forEach(System.out::println);
	}

	private void findDataContratacaoMaior(Scanner scanner) {
		System.out.println("Qual data de contratacao deseja pesquisar (dd/MM/yyyy):");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		List<Funcionario> list = repository.findDataContratacaoMaior(localDate);
		list.forEach(System.out::println);
	}
}